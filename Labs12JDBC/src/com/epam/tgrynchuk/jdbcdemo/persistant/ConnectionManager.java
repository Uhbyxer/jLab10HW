package com.epam.tgrynchuk.jdbcdemo.persistant;

import java.sql.*;

public class ConnectionManager {
	private static Connection conn;
	
	private   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private   static final String DB_URL = "jdbc:mysql://localhost/univer";

	   //  Database credentials
	private   static final String USER = "root";
	private   static final String PASS = "root";
	   
	private ConnectionManager() {}
	
	public static Connection getConnection() throws SQLException {
		
		if(conn == null) {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		
		return conn;
	}
}
