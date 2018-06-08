package com.svecw.greenbus.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Bus;
import com.svecw.greenbus.dto.User;
import com.svecw.greenbus.exception.GreenBusException;

public class UserDAO {
	public boolean insert(User user) throws GreenBusException {
		final String qstr = "insert into users(user_name,user_password,email_id,phone_number) values(?,?,?,?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = DAOUtility.getConnection().prepareStatement(qstr);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmailId());
			pstmt.setString(4, user.getPhoneNumber());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {
			try {
				if (pstmt != null) {

					pstmt.close();
				}
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}

		}
		return false;

	}

	public ArrayList<User> retriveAll() throws GreenBusException {

		Statement s = null;
		ArrayList<User> userList = null;
		try {
			s = DAOUtility.getConnection().createStatement();
			ResultSet rs = s.executeQuery("select * from users");
			if (rs.next()) {
				userList = new ArrayList<>();
				do {
					User temp = new User();
					temp.setUserName(rs.getString(2));
					temp.setPassword(rs.getString(3));
					temp.setEmailId(rs.getString(4));
					temp.setPhoneNumber(rs.getString(5));
					userList.add(temp);
				} while (rs.next());
			}
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {

			try {
				if (s != null) {
					s.close();
				}

			} catch (SQLException e) {
				throw new GreenBusException(e.toString());

			}
		}

		return userList;
	}


	public User getUser(String email) throws GreenBusException  {

		UserDAO obj = new UserDAO();
		List<User> userList = new ArrayList<>();
		try {
			userList = obj.retriveAll();
			for(User user: userList){
				if(user.getEmailId().equals(email)){
					return user;
				}
			}
		} catch (GreenBusException e) {
			throw new GreenBusException(e.toString());
		}
	
		return null;

	}
}
