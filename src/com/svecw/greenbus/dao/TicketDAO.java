package com.svecw.greenbus.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Ticket;
import com.svecw.greenbus.exception.GreenBusException;

public class TicketDAO {
	public boolean insert(String registrationNo, java.util.Date journeyDate, String emailId) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into ticket(registration_no,route_id,journey_date,user_id) values(?,?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, registrationNo);
			ps.setInt(2, getRouteId(registrationNo, journeyDate));
			ps.setDate(3, new java.sql.Date(journeyDate.getTime()));
			ps.setInt(4, getUserId(emailId));
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}

		}
		return false;
	}

	private int getUserId(String emailId) throws GreenBusException {
		PreparedStatement ps = null;
		String query = "select user_id from users where email_id = ?";
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, emailId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} catch (GreenBusException e) {
			throw new GreenBusException(e.toString());
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}

		}

	}

	private int getRouteId(String registrationNo, java.util.Date journeyDate) throws GreenBusException {
		PreparedStatement ps = null;
		String query = "select route_id from bus_route where registration_no = ? and Date(arrival_time) = ?";
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, registrationNo);
			ps.setDate(2, new java.sql.Date(journeyDate.getTime()));
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}

		}

	}
	public int getDistance(String registrationNo) throws GreenBusException{
		PreparedStatement ps = null;
		String query = "select distance from route where route_id in(select route_id from bus_route where registration_no = ?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, registrationNo);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}

		}

	}

}
