<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.svecw.greenbus.dao.*"%>
<%@page import="com.svecw.greenbus.dao.RouteDAO"%>
<%@page import="com.svecw.greenbus.dto.Route"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="adminlink.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@import url(design.css);
body {
	background-image: url("bg1.jpg");
	background-repeat: no-repeat;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="centered">
		<center>
			<h3>${successMessage}${errorMessage}</h3>
		</center>
		<form action="AdminServlet" method="post">


			<input type="hidden" name="action" value="get_available_buses" /> <br>
			<center>
				<font color="#8710c1" size=5> Source</font> <select id="source"
					name="source" class="source">

					<c:forEach var="route" items="${routeList}">
						<option value="${route.source}">${route.source}</option>
					</c:forEach>
				</select>
			</center>

			<center>
				<br>
				<font color="#8710c1" size=5> Destination</font> <select
					id="destination" name="destination" class="destination">

					<c:forEach var="route" items="${routeList}">
						<option value="${route.destination}">${route.destination}</option>
					</c:forEach>
				</select>
			</center>
			<center>
				<br> <font color="#8710c1" size=5> Enter Date</font><input
					type="text" name="date" placeholder="date"></input>
			</center>
			<center>
				<input type="submit" value="submit">
			</center>
		</form>
	</div>
</body>
</html>