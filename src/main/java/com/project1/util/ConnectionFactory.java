package com.project1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//jdbc:postgresql://database-1.cj7clghd6cph.us-east-1.rds.amazonaws.com:5432/postgres
	private static String URL = System.getenv("db_url");
	private static String USERNAME = System.getenv("db_username");
	private static String PASSWORD = System.getenv("db_password");
	
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	
}
