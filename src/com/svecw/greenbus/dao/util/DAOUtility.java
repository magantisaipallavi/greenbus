package com.svecw.greenbus.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.svecw.greenbus.exception.GreenBusException;

public class DAOUtility {
	public static Connection getConnection() throws GreenBusException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/greenbus", "root", "");
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e) {
			throw new GreenBusException(e.toString());
		}
		return con;
	}
}
