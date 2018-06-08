package com.svecw.greenbus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Admin;
import com.svecw.greenbus.dto.User;
import com.svecw.greenbus.exception.GreenBusException;

public class AdminDAO {
	public ArrayList<Admin> retriveAll() throws GreenBusException {

		Statement s = null;
		ArrayList<Admin> adminList = null;
		try {
			s = DAOUtility.getConnection().createStatement();
			ResultSet rs = s.executeQuery("select * from admin");
			if (rs.next()) {
				adminList = new ArrayList<>();
				do {
					Admin temp = new Admin();
					temp.setName(rs.getString(1));
					temp.setPassword(rs.getString(3));
					temp.setEmailId(rs.getString(2));
					temp.setPhoneNumber(rs.getString(4));
					adminList.add(temp);
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

		return adminList;
	}


	public Admin getAdmin(String email) throws GreenBusException  {

		AdminDAO obj = new AdminDAO();
		List<Admin> adminList = new ArrayList<>();
		try {
			adminList = obj.retriveAll();
			for(Admin admin: adminList){
				if(admin.getEmailId().equals(email)){
					return admin;
				}
			}
		} catch (GreenBusException e) {
			throw new GreenBusException(e.toString());
		}
	
		return null;

	}
}
