package com.cg.mysqljdbc;

import java.sql.*;

public class Update
{
	public static void main(String []args)
	{
		PreparedStatement mystmnt = null;
		ResultSet myRes = null;
		try 
		{
			Connection mycon =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","3733");
			//System.out.println("got connection");
			//create statement
			Statement mystmt = mycon.createStatement();
			
			mystmnt = mycon.prepareStatement("update employees set salary =? where  department=?");

			 

			//Set the parameters 
			mystmnt.setDouble(1,75000);
			mystmnt.setString(2,"HR");
			mystmnt.executeUpdate();
			myRes= mystmt.executeQuery("select * from employees");
			while(myRes.next())
			{
				String lastName = myRes.getString("last_name");
				String firstName = myRes.getString("first_name");
				double salary = myRes.getDouble("salary");
				String departments  = myRes.getString("department");
				System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}

