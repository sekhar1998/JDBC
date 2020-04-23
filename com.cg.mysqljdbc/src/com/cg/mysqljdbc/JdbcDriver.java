package com.cg.mysqljdbc;

import java.sql.*;

public class JdbcDriver {

	public static void main(String[] args) {
		
		try {// Get Connection To The DataBase
			Connection myCon =  DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?useSSL=false","root","sekhar1998");
			//create statement
			Statement stmt = myCon.createStatement();
			//execute as sql query
			String sql = "insert into books(tno,name,author) values(10,'jaja','kaja')";
			stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery("select * from books");
			while(rs.next())
		
			{
				System.out.println(rs.getString("name")+" "+rs.getString("author"));
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
