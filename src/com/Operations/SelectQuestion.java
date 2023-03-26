package com.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.DBConnection.DBConnection;
import com.exception.*;
public class SelectQuestion
{
	public static int count=0;
	public static void selectQuestion()
	{
		DBConnection dbc  = new DBConnection();
		try 
		{
			Connection con = dbc.getConnectionDetails();
			
			PreparedStatement ptmt = con.prepareStatement("Select * from questions order by rand()");
			ResultSet rs = ptmt.executeQuery();
			int Answer=0;
	
				while(rs.next())
				{
				
					System.out.println("\n Q : "+rs.getString(2));
					System.out.println("\n "+rs.getString(3));
					
					Answer=rs.getInt(4);
					findAnswer(Answer);
					System.out.println("\n_______________________________________________________________\n");
				}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//to find correct answer
	public static int findAnswer(int ans)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Plese select your option : ");
		int option = sc.nextInt();
		if(option == ans)
		{
			System.out.println("\n Yehh !! Your Answer is Correct... :)");
			count++;
		}
		else if (!(option >= 1 && option <= 4)) 
		{
			throw new InvalidOptionInputException(
					"Your Option should be Interger value from(1 to 4) only. Please Enter the Valid Option!");
		}
		else 
		{
			System.err.println("\n Wrong Answer :( 		Correct Option is " +ans);
		}
		return count;
	}

}
