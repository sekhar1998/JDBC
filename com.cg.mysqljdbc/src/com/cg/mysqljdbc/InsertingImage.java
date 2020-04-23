package com.cg.mysqljdbc;
import java.io.*;
import java.sql.*;

public class InsertingImage 
{
   public static void main(String args[]) throws Exception 
   {
	   Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject","root","3733");               
	   Statement stmt=mycon.createStatement(); 
	   //mycon.setAutoCommit(false);
       //Inserting values
       String s = "insert into employee(eid, ename , salary, image, resume) VALUES (?, ?, ?, ?, ?)";
       PreparedStatement pstmt = mycon.prepareStatement(s);
       pstmt.setInt(1, 101);
       pstmt.setString(2, "Grayson");
       pstmt.setInt(3, 15000);
       FileInputStream fin = new FileInputStream("C:\\Users\\Intel\\Desktop\\pic\\1.jpg");
       pstmt.setBinaryStream(4, fin);
       FileInputStream fin2 = new FileInputStream("H:\\phone\\Aleem Shaik.docx");
       pstmt.setBinaryStream(5, fin2);
       pstmt.execute();
       
       PreparedStatement pstmt1 = mycon.prepareStatement(s);
       pstmt1.setInt(1, 102);
       pstmt1.setString(2, "Jeremiah");
       pstmt1.setInt(3, 15000);
       FileInputStream fin3 = new FileInputStream("C:\\Users\\Intel\\Desktop\\pic\\1.jpg");
       pstmt1.setBinaryStream(4, fin3);
       FileInputStream fin4 = new FileInputStream("H:\\phone\\Aleem Shaik.docx");
       pstmt1.setBinaryStream(5, fin4);
       pstmt1.execute();
       
       PreparedStatement pstmt2 = mycon.prepareStatement(s);
       pstmt2.setInt(1, 103);
       pstmt2.setString(2, "Magi");
       pstmt2.setInt(3, 150000);
       FileInputStream fin5 = new FileInputStream("C:\\Users\\Intel\\Desktop\\pic\\1.jpg");
       pstmt2.setBinaryStream(4, fin5);
       FileInputStream fin6 = new FileInputStream("H:\\phone\\Aleem Shaik.docx");
       pstmt2.setBinaryStream(5, fin6);
       pstmt2.execute();
       
       System.out.println("Data inserted");
       ResultSet rs = stmt.executeQuery("Select * from employee");
       while(rs.next()) 
       {
         System.out.println("EID: "+rs.getInt("eid"));
         System.out.println("ENAME: "+rs.getString("ename"));
         System.out.println("SALARY: "+rs.getInt("salary"));
         System.out.println("IMAGE: "+rs.getBlob("image"));
         System.out.println("RESUME: "+rs.getClob("resume"));
       }
       try
       {
    	    mycon.setAutoCommit(false);
    	    mycon.commit();
    	} 
        catch (SQLException e) 
        {
    	    mycon.rollback();
    	}
   }
}
