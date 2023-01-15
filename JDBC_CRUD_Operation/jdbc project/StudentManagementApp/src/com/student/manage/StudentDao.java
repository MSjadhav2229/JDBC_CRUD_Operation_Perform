package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student st)

	{
		boolean f = false;
		try {
			// JDBC Code
			Connection con = CP.createC();
			String q = "insert into students.stu(sname,sphone,scity) values (?,?,?)";
			// PreparedStatemet
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			// execute
			pstmt.executeUpdate();
			f = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userID)

	{
		boolean f = false;
		try {
			// JDBC Code
			Connection con = CP.createC();
			String q = "delete from students.stu where sid=?";
			// PreparedStatemet
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameter
			pstmt.setInt(1, userID);

			// execute
			pstmt.executeUpdate();
			f = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			// JDBC Code
			Connection con = CP.createC();
			String q = "select * from students.stu;";
			// PreparedStatemet
//			Statement stmt = con.createStatement();
			Statement stmt = con.createStatement();

			ResultSet set = stmt.executeQuery(q);
			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");

				System.out.println("ID   :" + id);
				System.out.println("Name :" + name);
				System.out.println("Phone:" + phone);
				System.out.println("City :" + city);
				System.out.println("==========================");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
