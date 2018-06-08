<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="adminlink.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background-image: url("bg1.jpg");
	background-repeat: no-repeat;
}
table{
font-size:20px;
align:center;
}

@import url(design.css);
</style>
</head>
<body>
<div class="centered">
<center>
	<h3>${successMessage}${errorMessage}</h3>
</center>
<form action="AdminServlet" method="post">


	<input type="hidden" name="action" value="bus_info_table" /> <br>
	<center>
		<table border=2 width="900px" height="60px">
			<tr bgcolor="#fad1d1">
				<th>Registration Number</th>
				<th>Total Seats</th>
				<th>Bus Type</th>
				<th>Available Seats</th>
			</tr>
			<c:forEach var="info" items="${infoList}">
				<tr bgcolor="#FFE4C4">
					<td>${info.registrationNo}</td>
					<td>${info.seatCount}</td>
					<td>${info.busTypeName}</td>
					<td>${info.availableSeats}</td>

				</tr>
			</c:forEach>
		</table>
	</center>
</form>
</div>
</body>
</html>