package com.cg.mysqljdbc;

import java.sql.*;

public class Employee 
{
	public static void main(String args[]) throws SQLException
	{
		PreparedStatement mystmnt= null;
		ResultSet myRes= null;
		
			try 
			{
				Connection mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","3733");
				//create a statement
				Statement mystmt= mycon.createStatement();
				//prepare statement
				mystmnt = mycon.prepareStatement("select * from employees where salary >? or  department=? or email=?");
				//Set the parameters 
				//mystmnt.setDouble(1,75000);
				//mystmnt.setString(2,"Legal");
				//mystmnt.setString(3,"...");
				//Execute the SQL query 
				//myRes = mystmnt.executeQuery();
				mystmnt.setDouble(1,33000);
				mystmnt.setString(2,"HR");
				String pdept= "Engineering";
				int increaseAmount=10000;
				
				System.out.println("Salaries before\n");
				showSalaries(mycon, pdept);
				
				mystmnt =mycon.prepareCall("{call increase_salaries_fot_department(?,?)}");
				
				//set the parameters
				
				mystmnt.setString(1, pdept);
				mystmnt.setDouble(2, increaseAmount);
				
				//call Stores Procedures
				System.out.println("\n calling increased stored procedure. increase_salaries_fot_department(' "+ pdept + " '," + increaseAmount + ")");
				mystmnt.execute();
				System.out.println("Finished calling stored procedure");
				
				// Show salaries AFTER
				System.out.println("\n\n Salaries AFTER\n");
				showSalaries(mycon, pdept);
				
				/*while(myRes.next())
				{
					System.out.println(myRes.getString("last_name")+" "+myRes.getDouble("salary"));
				}
				//String sqlup= "update employees "+ "set id= 1107 "+ "set last_name='Graysonk' "+ "set first_name='Jeremiah' "+ "set email='grayson4yhwh@gmail.com' "+ "set department='Associate' "+ "set salary='100000' ";
				//mystmt.executeUpdate(sqlup);*/
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			finally
			{
				if(myRes != null)
				{
					myRes.close();
				}
				if(mystmnt != null)
				{
					mystmnt.close();
				}
			}
			
	
	}
	private static void display(ResultSet myRes) throws SQLException
	{
		while(myRes.next())
		{
			String lastName = myRes.getString("last_name");
			String firstName = myRes.getString("first_name");
			double salary = myRes.getDouble("salary");
			String department = myRes.getString("department");
			
			System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, salary, department);
		}
	}
	private static void showSalaries(Connection mycon, String pdept) 
	{
		// TODO Auto-generated method stub
		PreparedStatement mystmt= null;
		ResultSet myRs= null;
		try
		{
			//Prepare statement
			mystmt = mycon.prepareStatement("select * from employees where department=?");
			mystmt.setString(1, pdept);
			// Execute SQL query
			myRs = mystmt.executeQuery();
			// Process result set
			while (myRs.next())
			{
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, salary, department);
			}
		 }
		 catch(Exception exc)
		 {
			 exc.printStackTrace();
		 }
		 finally
		 {
			 close(mystmt, myRs);
		 }
	}
	private static void close(PreparedStatement mystmt, ResultSet myRs)
	{
		// TODO Auto-generated method stub
		
	}
}
