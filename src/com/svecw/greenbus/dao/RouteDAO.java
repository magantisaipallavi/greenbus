package com.svecw.greenbus.dao;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Route;
import com.svecw.greenbus.exception.GreenBusException;

public class RouteDAO {
	public boolean insert(Route route) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into route(source,destination,distance) values(?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, route.getSource());
			ps.setString(2, route.getDestination());
			ps.setInt(3, route.getDistance());
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

	public ArrayList<Route> retriveAll() throws GreenBusException {
		Statement s = null;
		ArrayList<Route> routeList = null;

		try {
			s = DAOUtility.getConnection().createStatement();
			ResultSet rs = s.executeQuery("select * from route");
			if (rs.next()) {
				routeList = new ArrayList<>();
				do {
					Route temp = new Route();
					temp.setRouteId(rs.getInt(1));
					temp.setSource(rs.getString(2));
					temp.setDestination(rs.getString(3));
					temp.setDistance(rs.getInt(4));
					routeList.add(temp);
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

		return routeList;
	}
	
	public Route getRoute(String source, String destination) throws GreenBusException{
		RouteDAO dao = new RouteDAO();
		List<Route> routeList = dao.retriveAll();
		for(Route route:routeList){
			if(route.getSource().equals(source) && route.getDestination().equals(destination))
				return route;
		}
		return null;
	}
}
