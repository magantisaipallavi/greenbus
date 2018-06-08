package com.svecw.greenbus.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Bus;
import com.svecw.greenbus.dto.Info;
import com.svecw.greenbus.exception.GreenBusException;

public class BusDAO {
	public boolean insert(Bus bus) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into bus values(?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, bus.getRegistrationNo());
			ps.setInt(2, bus.getBusTypeId());
			ps.setInt(3, bus.getSeatCount());

			if (ps.executeUpdate() > 0) {
				return true;
			}
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
		return false;
	}

	public ArrayList<Bus> retriveAll() throws GreenBusException {

		Statement s = null;
		ArrayList<Bus> busList = null;
		try {
			s = DAOUtility.getConnection().createStatement();
			ResultSet rs = s.executeQuery("select * from bus");
			if (rs.next()) {
				busList = new ArrayList<>();
				do {
					Bus temp = new Bus();
					temp.setRegistrationNo(rs.getString(1));
					temp.setBusTypeId(rs.getInt(2));
					temp.setSeatCount(rs.getInt(3));
					busList.add(temp);
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

		return busList;
	}

	public ArrayList<Info> getAvailableBuses(String source, String destination, Date journeyDate)
			throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "select b.registration_no,seat_count,type_name from bus b, bus_type bt, route r, bus_route br where b.registration_no = br.registration_no and b.bus_type_id = bt.bus_type_id  and r.route_id=br.route_id and r.source = ? and r.destination = ? and Date(arrival_time) = ? ";

		ArrayList<Info> infoList = null;
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, source);
			ps.setString(2, destination);
			ps.setDate(3, new java.sql.Date((journeyDate.getTime())));

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				infoList = new ArrayList<>();
				do {
					Info temp = new Info();
					temp.setRegistrationNo(rs.getString(1));
					temp.setSeatCount(rs.getInt(2));
					temp.setBusTypeName(rs.getString(3));
					temp.setAvailableSeats(
							temp.getSeatCount() - getAvailableSeatCount(temp.getRegistrationNo(), journeyDate));
					infoList.add(temp);
				} while (rs.next());
			}
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
		return infoList;
	}

	private int getAvailableSeatCount(String registrationNo, Date journeyDate) throws GreenBusException {
		PreparedStatement ps = null;
		String query = "select count(pd.seat_no) from ticket t, passenger_details pd where t.ticket_id = pd.ticket_id and t.registration_no = ? and t.journey_date = ?";
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, registrationNo);
			ps.setDate(2, new java.sql.Date(journeyDate.getTime()));
			ResultSet rs = ps.executeQuery();
			if (rs.next())
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
		return 0;
	}

	public List<Integer> getReservedSeatNo(String registrationNo, Date journeyDate) throws GreenBusException {
		List<Integer> reservedSeatNo = new ArrayList<Integer>();

		PreparedStatement ps = null;
		String query = "select seat_no from passenger_details where ticket_id in(select ticket_id from ticket where registration_no = ? and Date(journey_date) = ?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(query);
			ps.setString(1, registrationNo);
			ps.setDate(2, new java.sql.Date(journeyDate.getTime()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reservedSeatNo.add(rs.getInt(1));
			}
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
		return reservedSeatNo;
	}

}
