package com.cg.mysqljdbc;

import java.sql.*;

public class DataBaseMetaData {

	public static void main(String[] args) throws SQLException {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?useSSL=false","root","sekhar1998");
		System.out.println("Connection Established");
		Statement stmt = myCon.createStatement();
		System.out.println("Statement created");
		
		
		DatabaseMetaData dbmd = myCon.getMetaData();
		
		System.out.println("DB NAmE" + dbmd.getDatabaseProductName());
		System.out.println("db verSION" + dbmd.getDatabaseProductVersion());
		System.out.println("dB DriverNamE" + dbmd.getDriverName());
		
		
		System.out.println("==========Tables========");
		String t[] = {"Table"};
		ResultSet rs  = dbmd.getTables(null, null, null, t);
		
		while(rs.next())
		{
			System.out.println(rs.getString("TABLE_NAME"));
		}
	}

}
