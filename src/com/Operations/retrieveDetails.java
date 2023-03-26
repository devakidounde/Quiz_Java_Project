package com.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.DBConnection.DBConnection;

public class retrieveDetails 
{
	public static void retrieveMarks()
	{
		int id=0;
		Scanner sc = new Scanner(System.in);
		DBConnection dbc = new DBConnection();
		try 
		{
			Connection con = dbc.getConnectionDetails();
			System.out.print("\nPlease Enter Your Student ID : ");
			id=sc.nextInt();
			
			PreparedStatement ptmt = con.prepareStatement("Select StudentName,userNAme,marks from student_details where student_id=?");
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next())
			{
				System.out.println("\nName : "+rs.getString(1)+"\tUser Name : "+rs.getString(2)+"\tMarks : "+rs.getInt(3));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
