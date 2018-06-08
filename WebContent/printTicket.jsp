<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="link.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.btn{
width:360px;
}
</style>
</head>
<body>

	<center><h1>Your ticket Details</h1></center>
	<center><h3>TicketId:</h3><h4><%=request.getAttribute("ticketId") %></h4></center>
	<center><h3>RegistrationNo:</h3><h4><%=request.getAttribute("registrationNo")%></h4></center>
	<center><h3>ReservedSeat No's:</h3><h4><%=request.getAttribute("seats") %></h4></center>
	<center><h3>Cost:</h3><h4><%=request.getAttribute("cost") %></h4></center>
	<center><h3>JourneyDate:</h3><h4><%=request.getAttribute("journeyDate") %></h4></center>	
	<center><h3>EmailId:</h3><h4><%=request.getAttribute("emailId") %></h4></center>	
	<center><h1>HAPPY JOURNEY</h1></center>
</body>
</html>