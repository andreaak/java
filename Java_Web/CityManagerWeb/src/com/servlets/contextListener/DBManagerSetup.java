package com.servlets.contextListener;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.servlets.models.DBManager;
import com.servlets.models.MySQLServerConnectionBehavior;
import com.servlets.models.SQLiteConnectionBehavior;
import com.servlets.models.ServerConnectionBehavior;

@WebListener //or add definition in web.xml <listener>
public class DBManagerSetup implements ServletContextListener //add definition in web.xml <listener>
{
	public final static String ATTRIBUTE_NAME = "WorldDBManager";
	private DBManager dbm = null;
	public static String SERVER_CONTEXT_PATH;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//cleanup the connection when the context is destroyed
		if (dbm != null)
		{
			if (dbm.isConnected())
			{
				dbm.closeConnection(false);
			}
		}
		dbm = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//access the servlet context from the event argument (renamed sce)
		//get db con info from context init params
		ServletContext sc = sce.getServletContext();
		SERVER_CONTEXT_PATH = sc.getContextPath();
		String dbType = sc.getInitParameter("dbType");
		ServerConnectionBehavior scb = null;
		if(dbType == null) {
			dbType = "";
		}

		switch(dbType) {
			case "SQLite":
			default:
				String path1 = null;
				try {
					InitialContext ic = new InitialContext();
					DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");//tomcat
					//DataSource ds = (DataSource) ic.lookup("jdbc/Library");//glassfish
		            Connection conn = ds.getConnection();
		            path1 = conn.getMetaData().getURL();
		            if(path1 != null){
		            	path1 = path1.replaceFirst("jdbc:sqlite:", "");
		            }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
				String path = path1 == null ? sc.getRealPath("data.db") : path1;
				scb = new SQLiteConnectionBehavior(path);
				break;
			case "MySQL":
				String uid = sc.getInitParameter("dbuserid");
				String pwd = sc.getInitParameter("dbuserpwd");
				String cat = sc.getInitParameter("dbinitcat");
				scb = new MySQLServerConnectionBehavior(uid, pwd, cat);
				break;
		}
		
		//create the manager
		dbm = new DBManager(scb);
		
		//put the manager into the servlet context attributes for global use in
		//the application
		sc.setAttribute(ATTRIBUTE_NAME, dbm);
		
		System.out.println("WorldDBManager created and added to context");
	}
}
