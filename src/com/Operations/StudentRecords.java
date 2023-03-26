package com.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.DBConnection.DBConnection;

public class StudentRecords 
{
	public static void getStudentDetails() 
	{
		DBConnection dbc = new DBConnection();
		try 
		{
			Connection con = dbc.getConnectionDetails();
			PreparedStatement ptmt = con.prepareStatement("select student_id,StudentName,marks from student_details order by  marks desc");
			ResultSet rs  = ptmt.executeQuery();
			System.out.println("\n_______________________________________________________________\n");
			System.out.println("\nStudent Record - \n");
			while(rs.next())
			{
				System.out.print("Student ID - "+rs.getInt(1)+"\tName - "+rs.getString(2)+"\tMarks - "+rs.getInt(3)+"\n");
			}
			System.out.println("_______________________________________________________________");
			
			/*
			HashMap map = new HashMap();
			PreparedStatement ptmt1 = con.prepareStatement("select student_id,StudentName,marks from student_details order by  marks desc");
			ResultSet rs1  = ptmt.executeQuery();
			
			while (rs1.next()) 
			{
				map.put(rs1.getString(2), rs1.getInt(3));
			}
			Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

			System.out.print("Please find the Result below: \n");

			while (iterator.hasNext()) 
			{
				Map.Entry<String, Integer> entry = iterator.next();
				System.out.println("User: " + entry.getKey() + "   -   " + "Total Marks: " + entry.getValue());
			}*/
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
