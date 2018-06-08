<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><h3>${successMessage}${errorMessage}</h3></center>
	<form action="AdminServlet" method="post">


		<input type="hidden" name="action" value="passenger_info_table" /> <br>
		<center>
			<table border=2>
				<tr>
					<th>Ticket Id</th>
					<th>registration number</th>
					<th>Seat No</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Age</th>
					<th>JourneyDate</th>
				</tr>
				<c:forEach var="info" items="${PassengerInfoList}">
					<tr>
						<td>${info.Ticket Id}</td>
						<td>${info.registrationNo}</td>
						<td>${info.seatNo}</td>
						<td>${info.name}</td>
						<td>${info.gender}</td>
						<td>${info.age}</td>
						<td>${info.journeyDate}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</form>
</body>
</html>