<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.svecw.greenbus.dao.RouteDAO"%>
<%@page import="com.svecw.greenbus.dto.Route"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="link.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@import url(design.css);

.btn {
	width: 260px;
}

body {
	background-image: url("bg1.jpg");
	background-repeat: no-repeat;
}

@import url(design.css);

table {
	font-size: 20px;
	align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<h3>${successMessage}${errorMessage}</h3>
	</center>

	<form action="HomeServlet" method="post">


		<input type="hidden" name="action" value="bus_layout" /> <br>
		<center>
			<table align="center" width="900px" height="60px" border=2>
				<tr bgcolor="#fad1d1">
					<th>Registration Number</th>
					<th>Total Seats</th>
					<th>Bus Type</th>
					<th>Available Seats</th>
					<th></th>
				</tr>
				<c:forEach var="info" items="${infoList}">
					<tr bgcolor="#FFE4C4">
						<td>${info.registrationNo}</td>
						<td>${info.seatCount}</td>
						<td>${info.busTypeName}</td>
						<td>${info.availableSeats}</td>
						<c:if test="${info.availableSeats > 0}">
							<td><center>
									<button type="submit" name="regNo" style="color: red"
										value="${info.registrationNo}" />
									Book
								</center></td>
						</c:if>
						<c:if test="${info.availableSeats <= 0}">
						<td><center>
									<button type="submit" disabled ="disabled""regNo" style="color: red"
										value="${info.registrationNo}" />
									Book
								</center></td>
					</c:if>
						
					</tr>
					
				</c:forEach>
			</table>
		</center>
	</form>

</body>
</html>