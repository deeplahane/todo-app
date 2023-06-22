package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	
	private static Connection conn;
	
	public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp?autoReconnect=true&useSSL=false","root","Deeplahane2001#1");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
