package com.svecw.greenbus.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Bus;
import com.svecw.greenbus.dto.BusType;
import com.svecw.greenbus.exception.GreenBusException;

public class BusTypeDAO {
	public boolean insert(BusType bustype) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into bus_type(type_name) values(?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, bustype.getName());
			if (ps.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		}

		finally {

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

	public ArrayList<BusType> retriveAll() throws GreenBusException {

		Statement s = null;
		ResultSet rs = null;
		ArrayList<BusType> busTypes = null;
		try {
			s = DAOUtility.getConnection().createStatement();
			rs = s.executeQuery("select * from bus_type");
			if (rs.next()) {
				busTypes = new ArrayList<>();
				do {
					BusType temp = new BusType();
					temp.setBusTypeId(rs.getInt(1));
					temp.setName(rs.getString(2));
					busTypes.add(temp);
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

		return busTypes;

	}

}
