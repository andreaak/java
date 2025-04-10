package com.database._01_jdbc._00_base;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SQLiteTest {

	@Test
	public void sqlliteTest() {

		// now we set up a set of fairly basic string variables to use in the
		// body of the code proper
		String sDriverName = "org.sqlite.JDBC";

		String sTempDb = ".\\data.db";
		String sJdbc = "jdbc:sqlite";
		String sDbUrl = sJdbc + ":" + sTempDb;
		// which will produce a legitimate Url for SqlLite JDBC :
		// jdbc:sqlite:data.db
		int iTimeout = 30;
		String dropTable = "DROP TABLE dummy";
		String sMakeTable = "CREATE TABLE dummy (id numeric, response text)";
		String sMakeInsert = "INSERT INTO dummy VALUES(1,'Hello from the database')";
		String sMakeSelect = "SELECT response from dummy";

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
			tableRs =  meta.getTables(null, null, "dummy", new String[] { "TABLE"});
			boolean isTableFound = false;
			while(tableRs.next())
			{
				String tableName = tableRs.getString("TABLE_NAME");
				if("dummy".equals(tableName))
				{
					isTableFound = true;
					break;
				}
			}
			JDBCUtils.closeResultSet(tableRs);
			if(isTableFound) {
				stmt.executeUpdate(dropTable);
			}
			stmt.executeUpdate(sMakeTable);
			stmt.executeUpdate(sMakeInsert);
			rs = stmt.executeQuery(sMakeSelect);
			while (rs.next()) {
				String sResult = rs.getString("response");
				System.out.println(sResult);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(stmt);
			JDBCUtils.closeConnection(conn);
		}
	}
}
