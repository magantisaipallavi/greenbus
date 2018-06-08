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

import com.svecw.greenbus.dao.BusDAO;
import com.svecw.greenbus.dao.PassengerDetailsDAO;
import com.svecw.greenbus.dao.RouteDAO;
import com.svecw.greenbus.dao.TicketDAO;
import com.svecw.greenbus.dao.UserDAO;
import com.svecw.greenbus.dto.Info;
import com.svecw.greenbus.dto.PassengerDetails;
import com.svecw.greenbus.dto.Route;
import com.svecw.greenbus.dto.Ticket;
import com.svecw.greenbus.dto.User;
import com.svecw.greenbus.exception.GreenBusException;
import com.svecw.greenbus.util.DateUtility1;

@WebServlet("/HomeServlet")

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("search_form")) {
			try {
				List<Route> routeList = new RouteDAO().retriveAll();
				request.setAttribute("routeList", routeList);
				request.getRequestDispatcher("selectBuses.jsp").forward(request, response);
			} catch (GreenBusException e) {
				e.printStackTrace();
			}
		}else if(action != null && action.equals("logout")){
			 HttpSession session=request.getSession();
		        String name = (String)session.getAttribute("username");
		        if(name != null ){
		            session.invalidate();  
		            request.getRequestDispatcher("homePage.jsp").forward(request, response);
		        }
		        else{

					request.getRequestDispatcher("homePage.jsp").forward(request, response);
				}
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("signup")) {
			HttpSession session = request.getSession();
			User user = new User();
			user.setEmailId(request.getParameter("emailid"));
			user.setPassword(request.getParameter("password"));
			user.setPhoneNumber(request.getParameter("phno"));
			user.setUserName(request.getParameter("username"));
			session.setAttribute("username",request.getParameter("emailid") );
			request.setAttribute("username",request.getParameter("emailid"));
			try {
				if (new UserDAO().insert(user)) {
					request.getRequestDispatcher("loginpage.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", "you are already an existing user");
				request.getRequestDispatcher("homePage.jsp").forward(request, response);
			}

		} else if (action.equals("userlogin")) {
			HttpSession session = request.getSession();
			User user = new User();
			String email = request.getParameter("emailid");
			String password = request.getParameter("password");
			try {
				user = new UserDAO().getUser(email);
				if(user != null){
				if (user.getPassword().equals(password)) {
					session.setAttribute("username", email);
					request.setAttribute("username", email);
					request.getRequestDispatcher("loginpage.jsp").forward(request, response);
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

		} else if (action.equals("get_available_buses")) {
			BusDAO dao = new BusDAO();
			HttpSession session = request.getSession();
			ArrayList<Info> infoList = new ArrayList<>();
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			Date journeyDate = DateUtility1.convertStringToDate(request.getParameter("date"));
			System.out.println(journeyDate);
			session.setAttribute("journeyDate", journeyDate);
			try {
				infoList = dao.getAvailableBuses(source, destination, journeyDate);
				if (null != infoList) {
					request.setAttribute("infoList", infoList);
					request.getRequestDispatcher("showBusDetails.jsp").forward(request, response);
				}else{
					request.setAttribute("successMessage", "Sorry buses are not available");
					request.getRequestDispatcher("loginpage.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("showBusDetails.jsp").forward(request, response);
			}
		} else if (action.equals("bus_layout")) {
			TicketDAO tdao = new TicketDAO();
			try {
				HttpSession session = request.getSession();
				BusDAO dao = new BusDAO();
				session.setAttribute("registrationNo", request.getParameter("regNo"));
				System.out.println(session.getAttribute("journeyDate"));
				List<Integer> reservedSeatNoList = dao.getReservedSeatNo(request.getParameter("regNo"),
						(Date) session.getAttribute("journeyDate"));
				request.setAttribute("cost",tdao.getDistance(request.getParameter("regNo"))*1.5);
				request.setAttribute("reservedSeatNoList", reservedSeatNoList);
				request.getRequestDispatcher("seatLayout.jsp").forward(request, response);
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("showBusDetails.jsp").forward(request, response);
			}

		} else if (action.equals("get_reserved_seats")) {
			TicketDAO tdao = new TicketDAO();
			PassengerDetailsDAO pdao = new PassengerDetailsDAO();
			PassengerDetails pd = new PassengerDetails();
			HttpSession session = request.getSession();
			String[] selectedSeats = request.getParameterValues("seats");
			String seats = "";
			request.setAttribute("selectedSeats", selectedSeats);
			int ticketId = 0;
			try {
				if (tdao.insert((String) session.getAttribute("registrationNo"),
						(Date) session.getAttribute("journeyDate"), (String) session.getAttribute("username"))) {
					for (int i = 0; i < selectedSeats.length; i++) {
						seats += "      " + selectedSeats[i];
						System.out.println(session.getAttribute("username"));
						ticketId = pdao.getTicketId((String) session.getAttribute("registrationNo"),
								(Date) session.getAttribute("journeyDate"), (String) session.getAttribute("username"));
						if (pdao.insert(ticketId, selectedSeats[i])) {
							System.out.println("passenger inserted");
						}

					}
					request.setAttribute("ticketId", ticketId);
					request.setAttribute("registrationNo", session.getAttribute("registrationNo"));
					request.setAttribute("journeyDate", session.getAttribute("journeyDate"));
					request.setAttribute("emailId", session.getAttribute("username"));
					request.setAttribute("cost", (tdao.getDistance((String)session.getAttribute("registrationNo"))*(selectedSeats.length)*1.5));
					request.setAttribute("seats", seats);
					request.getRequestDispatcher("printTicket.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("loginpage.jsp").forward(request, response);
			}

		}
	}

}
