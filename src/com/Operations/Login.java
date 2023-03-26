package com.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.DBConnection.*;
import com.exception.*;
public class Login 
{
	private static String studentName;
	private static String userName;
	private static String password;
	
	public static String getStudentName() {
		return studentName;
	}
	public static void setStudentName(String studentName) {
		Login.studentName = studentName;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		Login.userName = userName;
	}
	public String getPassword() {
		return password;
	}

	
	public static void userLogin()  
	{
		Scanner sc = new Scanner(System.in);
		System.out.print(" Please Enter Your Full Name : ");
		studentName = sc.nextLine();
		System.out.print(" Enter Your User Name : ");
		userName = sc.nextLine();
		System.out.print(" Enyer Your Password : ");
		password = sc.next();
		DBConnection dbc = new DBConnection();
		try 
		{
			Connection con = dbc.getConnectionDetails();
			PreparedStatement pStatement = con.prepareStatement("select * from student_details");
			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				if (userName.equals(resultSet.getString(2))) {
					throw new DuplicateUserException(
							"User Already Exists with name: " + userName + "! Please try again with another..");
				}
			}

			PreparedStatement ptmt = con.prepareStatement("insert into Student_Details(studentName,userName,password) values(?,?,?)");
			ptmt.setString(1, studentName);
			ptmt.setString(2, userName);
			ptmt.setString(3, password);
			
			ptmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
