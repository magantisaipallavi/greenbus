
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
#busTypeId {
	width: 260px;
	height: 30px;
	margin-left: 50px;
	
}
#seatCount {
	width: 260px;
	margin-left: 100px;
	
}
.centered {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	transform: -webkit-translate(-50%, -50%);
	transform: -moz-translate(-50%, -50%);
	transform: -ms-translate(-50%, -50%);
}

@import
url(design.css)
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
	
	
		<input type="hidden" name="action" value="add_bus" />
		<center>
			<font color = "#8710c1" size = 5>Registration Number</font><input type="text" name="registrationNo"></input>
		</center>
		<br>
		<center>
			<font color = "#8710c1" size = 5>Bus Type Name</font><select id="busTypeId" name="busTypeId" class="busTypeId"><br>

				<c:forEach var="busType" items="${busTypesList}">
					<option value="${busType.busTypeId}" >${busType.name}</option>
				</c:forEach>
			</select>
		</center>
		<br>
		<center>
			<font color = "#8710c1" size = 5>Seat Count </font><input type="text" id = "seatCount" name="seatCount"></input>
		</center>
		<br> <br>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
</div>
</body>
</html>