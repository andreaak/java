package com.database._01_jdbc._00_base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {

	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception ignore) {
		}
	}

	public static void closeStatement(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception ignore) {
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception ignore) {
		}
	}
}