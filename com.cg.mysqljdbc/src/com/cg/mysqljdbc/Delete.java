package com.cg.mysqljdbc;

import java.sql.*;

public class Delete 
{
	public static void main(String []args)
	{
		PreparedStatement myStmnt = null;
		ResultSet myRes = null;
		try
		{
			Connection myCon=  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","3733");
			//System.out.println("got connection");
			//create statement
			Statement mystmt = myCon.createStatement();
			myStmnt = myCon.prepareStatement("delete from employees  where  department=?");
			//Set the parameters 
			myStmnt.setString(1,"HR");
			myStmnt.executeUpdate();
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

