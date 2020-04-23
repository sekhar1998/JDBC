package com.cg.mysqljdbc;

import java.sql.*;
import java.sql.CallableStatement;

public class InAndOut 
{
	public static void main(String[] args) throws SQLException 
	{
	     PreparedStatement myStmnt= null;
	     ResultSet myRes = null;

	    	 try 
	    	 {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","3733");
				 String pdept = "Engineering";
				 myStmnt =myConn.prepareCall("{call greet_the_department(?)}");
				 ((CallableStatement) myStmnt).registerOutParameter(1,100);
			 } 
	    	 catch (SQLException e) 
	    	 {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
	}     
}
