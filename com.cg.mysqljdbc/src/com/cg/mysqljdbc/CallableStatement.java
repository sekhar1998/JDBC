package com.cg.mysqljdbc;

import java.sql.*;

public class CallableStatement
{
	public static void main(String[] args) throws SQLException 
	{
	     PreparedStatement myStmnt= null;
	     ResultSet myRes = null;
	     
	
	     try 
	     {

	    	 Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","3733");
	    	 //create a statement
	    	 Statement mystmt =myConn.createStatement();

	    	 String pdept = "Engineering";
	    	 int increaseAmount = 10000;
		
	    	 //show before salaries
	    	 System.out.println("salaries before\n");
	    	 showSalaries(myConn, pdept);
		
	    	 myStmnt =myConn.prepareCall("{call increase_salaries_for_department(?,?)}");
		
	    	 //set the parameters
		
	    	 myStmnt.setString(1,pdept);
	    	 myStmnt.setDouble(2,increaseAmount);
		
	    	 //call Stored Procedures
	    	 System.out.println("\n calling increased stored procedure . increase_salaries_for_department('"+ pdept + "'," + increaseAmount+ ")");
	    	 myStmnt.execute();
	    	 System.out.println("Finished calling stored procedure");

	    	 // Show salaries AFTER
	    	 System.out.println("\n\nSalaries AFTER\n");
	    	 showSalaries(myConn, pdept);

	     }
	     catch (Exception exc)
	     {
	    	 exc.printStackTrace();
	     }  
	     finally
	     {
	    	 if (myRes != null) 
	    	 {
	    		 myRes.close();
	    	 }
	    	 if(myStmnt != null)
	    	 {
	    		 myStmnt.close();
			    
	    	 }
	     }
	}
	private static void showSalaries(Connection myConn , String pdept) throws SQLException 
	{
	   PreparedStatement myStmt = null;
	   ResultSet myRs = null;
	   
	   try 
	   {
		    // Prepare statement
			myStmt = myConn.prepareStatement("select * from employees where department=?");

			myStmt.setString(1, pdept);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) 
			{
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
		} 
	    catch (Exception exc) 
	    {
			exc.printStackTrace();
		}
	    finally 
	    {
			close(myStmt, myRs);
		}

	}

	private static void close(Connection myConn, Statement myStmt,ResultSet myRs) throws SQLException 
	{
		if (myRs != null) 
		{
			myRs.close();
		}

		if (myStmt != null) 
		{
			myStmt.close();
		}

		if (myConn != null) 
		{
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)throws SQLException 
	{

		close(null, myStmt, myRs);
	}

}


