package com.wipro.bank.util;
import java.sql.*;


public class DButil{
	static Connection con=null;
	public static Connection getDBConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bank?user=root&password=");
		}
		catch(Exception e){}
		return con;
	}
}

