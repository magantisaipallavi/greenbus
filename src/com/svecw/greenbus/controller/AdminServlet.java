package com.svecw.greenbus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.svecw.greenbus.dao.AdminDAO;
import com.svecw.greenbus.dao.BusDAO;
import com.svecw.greenbus.dao.BusRouteDAO;
import com.svecw.greenbus.dao.BusTypeDAO;

import com.svecw.greenbus.dao.RouteDAO;
import com.svecw.greenbus.dao.UserDAO;
import com.svecw.greenbus.dto.Admin;
import com.svecw.greenbus.dto.Bus;
import com.svecw.greenbus.dto.BusRoute;
import com.svecw.greenbus.dto.BusType;
import com.svecw.greenbus.dto.Info;

import com.svecw.greenbus.dto.Route;
import com.svecw.greenbus.dto.User;
import com.svecw.greenbus.exception.GreenBusException;
import com.svecw.greenbus.util.DateUtility;
import com.svecw.greenbus.util.DateUtility1;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (null != action) {
			if (action.equals("show_bus_type_form")) {
				response.sendRedirect("addBusType.jsp");
			} else if (action.equals("show_bus_form")) {
				try {
					List<BusType> busTypesList = new BusTypeDAO().retriveAll();
					request.setAttribute("busTypesList", busTypesList);
					request.getRequestDispatcher("addBus.jsp").forward(request, response);
				} catch (GreenBusException e) {
					request.setAttribute("errorMessage", e.toString());
					request.getRequestDispatcher("adminHome.jsp").forward(request, response);
				}
			} else if (action.equals("show_bus_route_form")) {
				try {
					List<Route> routeList = new RouteDAO().retriveAll();
					List<Bus> busList = new BusDAO().retriveAll();
					request.setAttribute("routeList", routeList);
					request.setAttribute("busList", busList);
					request.getRequestDispatcher("addBusRoute.jsp").forward(request, response);
				} catch (GreenBusException e) {
					request.setAttribute("errorMessage", e.toString());
					request.getRequestDispatcher("adminHome.jsp").forward(request, response);
				}

			} else if (action.equals("show_route_form")) {
				response.sendRedirect("addRoute.jsp");
			} else if (action.equals("search_form")) {
				List<Route> routeList;
				try {
					routeList = new RouteDAO().retriveAll();
					request.setAttribute("routeList", routeList);
					request.getRequestDispatcher("searchBuses.jsp").forward(request, response);
				} catch (GreenBusException e) {
					request.setAttribute("errorMessage", e.toString());
					request.getRequestDispatcher("searchBuses.jsp").forward(request, response);
				}
			}else if(action != null && action.equals("logout")){
				 HttpSession session=request.getSession();
			        String name = (String)session.getAttribute("username");
			        if(name != null ){
			        	System.out.println("logged out !!!");
			            session.invalidate();  
			            request.getRequestDispatcher("homePage.jsp").forward(request, response);
			        }
			        else{

						request.getRequestDispatcher("homePage.jsp").forward(request, response);
					}
				} 
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("adminlogin")){
			Admin admin = new Admin();
			String email = request.getParameter("emailid");
			String password = request.getParameter("password");
			try {
				admin = new AdminDAO().getAdmin(email);
				if(admin != null){
				if (admin.getPassword().equals(password)) {
					request.getRequestDispatcher("adminHome.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("homePage.jsp").forward(request, response);
				}
				}else{
					request.getRequestDispatcher("homePage.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("homePage.jsp").forward(request, response);
			}
		}else
		if (action.equals("add_route")) {
			Route route = new Route();
			RouteDAO dao = new RouteDAO();
			route.setDestination(request.getParameter("destination"));
			route.setSource(request.getParameter("source"));
			route.setDistance(Integer.parseInt(request.getParameter("distance")));
			try {
				if (dao.insert(route)) {
					request.setAttribute("successMessage", "Route Added Successfully !!!");
					request.getRequestDispatcher("addRoute.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addRoute.jsp").forward(request, response);
			}
		} else if (action.equals("add_bus")) {
			Bus bus = new Bus();
			BusDAO dao = new BusDAO();
			bus.setRegistrationNo(request.getParameter("registrationNo"));
			bus.setBusTypeId(Integer.parseInt(request.getParameter("busTypeId")));
			bus.setSeatCount(Integer.parseInt(request.getParameter("seatCount")));
			try {
				if (dao.insert(bus)) {
					request.setAttribute("successMessage", "Bus Added Successfully !!!");
					request.getRequestDispatcher("addBus.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addBus.jsp").forward(request, response);
			}
		} else if (action.equals("add_bus_type")) {
			BusType busType = new BusType();
			BusTypeDAO dao = new BusTypeDAO();
			busType.setName(request.getParameter("busType"));
			try {
				if (dao.insert(busType)) {
					request.setAttribute("successMessage", "Bus Type Added Successfully !!!");
					request.getRequestDispatcher("addBusType.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addBusType.jsp").forward(request, response);
			}
		} else if (action.equals("add_bus_route")) {

			BusRoute busRoute = new BusRoute();
			BusRouteDAO dao = new BusRouteDAO();
			try {

				Route route = new RouteDAO().getRoute(request.getParameter("source"),
						request.getParameter("destination"));
				busRoute.setRouteId(route.getRouteId());
				busRoute.setRegistrationNo(request.getParameter("registrationNo"));
				busRoute.setArrivalTime(DateUtility.convertStringToDate(request.getParameter("arrivalTime")));
				busRoute.setDepartureTime(DateUtility.convertStringToDate(request.getParameter("departureTime")));
				if (dao.insert(busRoute)) {
					request.setAttribute("successMessage", "Bus Route Added Successfully !!!");
					request.getRequestDispatcher("addBusRoute.jsp").forward(request, response);
				}

			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addBusRoute.jsp").forward(request, response);
			}
		} else if (action.equals("get_available_buses")) {
			BusDAO dao = new BusDAO();
			ArrayList<Info> infoList = new ArrayList<>();
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			Date journeyDate = DateUtility1.convertStringToDate(request.getParameter("date"));
			try {
				infoList = dao.getAvailableBuses(source, destination, journeyDate);
				if (null != infoList) {
					request.setAttribute("infoList", infoList);
					request.getRequestDispatcher("showBusesInfo.jsp").forward(request, response);
				}else{
					request.setAttribute("successMessage", "Sorry buses are not available");
					request.getRequestDispatcher("adminHome.jsp").forward(request, response);
					
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("showBusesInfo.jsp").forward(request, response);
			}
		} 

	}
}
