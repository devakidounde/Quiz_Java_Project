package com.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBConnection.DBConnection;

public class Result extends SelectQuestion
{
	public static void getResult() 
	{
		SelectQuestion sq=new SelectQuestion();
		int marks=sq.count;
		DBConnection dbc = new DBConnection();
		try 
		{
			Connection con = dbc.getConnectionDetails();
			PreparedStatement ptmt = con.prepareStatement("update student_details set marks=? where userName=?");
			Login lg=new Login();
			ptmt.setString(2, lg.getUserName());
			ptmt.setInt(1, marks);
			
			int i = ptmt.executeUpdate();
			
			if(marks >= 8 )
				System.out.println("\n Your Score is "+marks+"  __  Class A - Excellent !!");
			else if(marks >= 6 & marks <8)
				System.out.println("\n Your Score is "+marks+"  __  Class B - Good !!");
			else if(marks <= 5 & marks>6)
				System.out.println("\n Your Score is "+marks+"  __  Class C - Average !!");
			else if(marks <5)
				System.out.println("\n Your Score is "+marks+"  __  Sorry.. you are failed.. :(");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}