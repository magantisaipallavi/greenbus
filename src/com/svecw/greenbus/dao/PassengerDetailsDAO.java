package com.svecw.greenbus.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.PassengerDetails;
import com.svecw.greenbus.dto.Ticket;
import com.svecw.greenbus.exception.GreenBusException;

public class PassengerDetailsDAO {
	public boolean insert(int ticketId, String seatNo) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into passenger_details values(?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setInt(1, ticketId);
			ps.setInt(2, Integer.parseInt(seatNo));
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new GreenBusException(e.toString());
				}
			}

		}
		return false;
	}

	public int getTicketId(String registrationNo, Date journeyDate, String emailId) throws GreenBusException {
		PreparedStatement ps = null;
		String query = "select max(ticket_id) from ticket t, users u where registration_no = ? and Date(journey_date) = ? and t.user_id = u.user_id and u.email_id = ?";
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, registrationNo);
			ps.setDate(2, new java.sql.Date(journeyDate.getTime()));
			ps.setString(3, emailId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}
		}
	}
	
	
}
