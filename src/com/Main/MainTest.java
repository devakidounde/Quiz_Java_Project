package com.Main;
import java.sql.SQLException;
import java.util.Scanner;

import com.Operations.*;
public class MainTest 
{

	public static void main(String[] args) throws SQLException 
	{
		System.out.println("\n_______________________________________________________________\n");
		
		Login.userLogin();
		
		System.out.println("\n_______________________________________________________________\n");
		
		System.err.println("\n WELCOME TO THE EXCITING CORE JAVA QUIZ\n");
		
		
		
		SelectQuestion.selectQuestion();
		
		
		
		Result.getResult();
		
		
		StudentRecords.getStudentDetails();
		
		
		System.out.print("\n Do you want to Retrive your marks and Details ? [1/0] : ");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		if(s==1)
		{
			retrieveDetails.retrieveMarks();
			System.out.println("Thank You !");
		}
		else
			System.out.println("\n GOOD LUCK! :)");
	}
}
