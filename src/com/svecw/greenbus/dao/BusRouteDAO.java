package com.svecw.greenbus.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.BusRoute;

import com.svecw.greenbus.exception.GreenBusException;

public class BusRouteDAO {
	public boolean insert(BusRoute busRoute) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into bus_route values(?,?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setInt(1, busRoute.getRouteId());
			ps.setString(2, busRoute.getRegistrationNo());
			ps.setTimestamp(3, new java.sql.Timestamp(busRoute.getArrivalTime().getTime()));
			ps.setTimestamp(4,new java.sql.Timestamp(busRoute.getDepartureTime().getTime()));
			
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
}
