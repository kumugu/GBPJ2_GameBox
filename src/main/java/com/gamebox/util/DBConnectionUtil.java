package com.gamebox.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "rmarn";
	private static final String PASSWORD = "1234";
	
	private DBConnectionUtil() { }

	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to connect to database", e);
		}
	}
}
