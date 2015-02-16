package com.servlets.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnectionBehavior
	extends DBUserInfo
	implements ServerConnectionBehavior
{
	String dbPath;
	
	public SQLiteConnectionBehavior()
	{
		super();
	}
	
	public SQLiteConnectionBehavior(String dbPath)
	{
		super(null, null, null);
		this.dbPath = dbPath;
	}

	@Override
	public Connection getConnection() {
		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			Connection cn = DriverManager.getConnection(getConnectionURL());
			return cn;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getConnectionURL() {
		return "jdbc:sqlite:" + dbPath;
	}

	@Override
	public String getConnectionDetails() {
		return "sqlite Database Connection";
	}

	@Override
	public String getTablesSchemaQuery() {
		return "select table_name from information_schema.tables "
					+ "where table_schema = " + getCatalog();
	}
}
