package com.servlets.db.helpers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;

public class Database {
    
    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;
    
    public static Connection getConnection() {
        try {
            ic = new InitialContext();
            //ds = (DataSource) ic.lookup("jdbc/Library");//glassfish
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");//tomcat
            //if (conn==null) 
            {
                conn = ds.getConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
	public static boolean check() {

        try {
            InitialContext ic = new InitialContext();
            //DataSource ds = (DataSource) ic.lookup("jdbc/Library");//glassfish
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");//tomcat
            //Context dbContext = (Context) ic.lookup("java:comp/env");//tomcat2
            //DataSource ds = (DataSource) dbContext.lookup("jdbc/Library");//tomcat2
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
	
	@Test
	public void sqlliteTest() {

		// now we set up a set of fairly basic string variables to use in the
		// body of the code proper
		String sDriverName = "org.sqlite.JDBC";

		String sTempDb = "D:\\Prj\\Java_Web\\CityManagerWeb\\WebContent\\data.db";
		String sJdbc = "jdbc:sqlite";
		String sDbUrl = sJdbc + ":" + sTempDb;
		// which will produce a legitimate Url for SqlLite JDBC :
		// jdbc:sqlite:data.db
		int iTimeout = 30;
		String dropTable = "DROP TABLE city_clone";
		String sMakeTable = "CREATE TABLE city_clone (id numeric, name text, countrycode text)";
		String sMakeInsert = "INSERT INTO city_clone(id, name, countrycode) "
				+ "SELECT 1,'LA', 'USA'"
				+ "UNION ALL SELECT 2,'NY', 'USA'";
		String sMakeSelect = "SELECT name from city_clone";

		// create a database connection
		Connection conn = null;
		ResultSet tableRs =null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			// register the driver
			Class.forName(sDriverName);
			conn = DriverManager.getConnection(sDbUrl);

			stmt = conn.createStatement();
			stmt.setQueryTimeout(iTimeout);
			
			DatabaseMetaData meta = conn.getMetaData();
			tableRs =  meta.getTables(null, null, "city_clone", new String[] { "TABLE"});
			boolean isTableFound = false;
			while(tableRs.next())
			{
				String tableName = tableRs.getString("TABLE_NAME");
				if("city_clone".equals(tableName))
				{
					isTableFound = true;
					break;
				}
			}
			closeResultset(tableRs);
			if(isTableFound) {
				stmt.executeUpdate(dropTable);
			}
			stmt.executeUpdate(sMakeTable);
			stmt.executeUpdate(sMakeInsert);
			rs = stmt.executeQuery(sMakeSelect);

			while (rs.next()) {
				String sResult = rs.getString("name");
				System.out.println(sResult);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeResultset(tableRs);
			closeResultset(rs);
			closeStatement(stmt);
			closeConnection(conn);
		}
		
	}
	
	public  static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (Exception ignore) {
		}
	}
	
	public static void closeStatement(Statement st){
		try {
			st.close();
		} catch (Exception ignore) {
		}
	}
	
	public static void closeResultset(ResultSet rs){
		try {
			rs.close();
		} catch (Exception ignore) {
		}
	}
}
