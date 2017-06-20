package com.gourav.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gourav.entity.Profile;

public class DataBaseUtils {

	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	static final String USER = "system";
	static final String PASSWORD = "system";
	
	public static void save(Profile profile){
		
		Connection conn = null;

		try {
			System.out.println("Step#2 registering JDBC driver");
			Class.forName(JDBC_DRIVER);
			
			
			System.out.println("Step#3 Open a connection and connecting to DB");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			String query = "insert into profile(email ,	name ,	age ,	gender)" + "values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareCall(query);
			preparedStatement.setString(1, profile.getEmail());
			preparedStatement.setString(2, profile.getName());
			preparedStatement.setString(3, profile.getAge());
			preparedStatement.setString(4, profile.getGender());
			
			preparedStatement.execute();
			
			System.out.println("saved profile successfully");
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	
	}

}
