
<%@ page language="java" contentType="text/html"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svecw.greenbus.dao.BusTypeDAO"%>
<%@page import="com.svecw.greenbus.dto.BusType"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="adminlink.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
body {
	background-image: url("bg1.jpg");
	background-repeat:no-repeat;
}
#source{
	width: 260px;
	height: 30px;
	margin-left: 50px;
	
}
#destination{
	width: 260px;
	height: 30px;
	margin-left: 50px;
	
}
#registrationNO{
	width: 260px;
	height: 30px;
	margin-left: 50px;
	
}


@import
url(design.css);
</style>
<script>
	
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="centered">
	<center><h3>${successMessage}${errorMessage}</h3></center>
	<form action="AdminServlet" method="post">
	
	
		<input type="hidden" name="action" value="add_bus_route" />
		<center><font color = "#8710c1" size = 5>
			Source</font><select id="source" name="source" class="source"><br>

				<c:forEach var="route" items="${routeList}">
					<option value="${route.source}" >${route.source}</option>
				</c:forEach>
			</select>
			</center><br>
			
			<center><font color = "#8710c1" size = 5>
			Destination</font><select id="destination" name="destination" class="destination"><br>

				<c:forEach var="route" items="${routeList}">
					<option value="${route.destination}" >${route.destination}</option>
				</c:forEach>
			</select>
			</center><br>
			
		<center><font color = "#8710c1" size = 5>
			RegistrationNo</font> <select id="registrationNo" name="registrationNo" class="registrationNo"><br>

				<c:forEach var="bus" items="${busList}">
					<option value="${bus.registrationNo}" >${bus.registrationNo}</option>
				</c:forEach>
			</select>
		</center>
		<br>
		
		<center><font color = "#8710c1" size = 5>
			ArrivalTime </font><input type="text" name="arrivalTime"></input>
		</center>
		<br>
		<center><font color = "#8710c1" size = 5>
			DepatureTime</font> <input type="text" name="departureTime"></input>
		</center>
		<br> 
		 <br>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
	</div>
</body>
</html>