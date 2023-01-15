//CP (connection_provider)

package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CP {
	static Connection con;

	public static Connection createC() throws SQLException {

		try {
			// laod the driver
			Class.forName("com.mysql.jdbc.Driver");

			// create connection
//			String q = "insert into students(sname,sname,scity) values(?,?,?)";
////preperatedStatement
//			PreparedStatement pstmt = con.prepareStatement(q);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
//			// set the value of parameters
//			pstmt.setString(1,st.getStudent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
