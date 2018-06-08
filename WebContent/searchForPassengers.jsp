<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.svecw.greenbus.dao.*"%>
<%@page import="com.svecw.greenbus.dao.RouteDAO"%>
<%@page import="com.svecw.greenbus.dto.Route"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@import url(design.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><h3>${successMessage}${errorMessage}</h3></center>
	<form action="AdminServlet" method="post">

		<input type="hidden" name="action" value="get_passenger_info" /> <br>
		<center>
			<br> Enter Date<input type="text" name="date" placeholder="date"></input>
		</center>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>

</body>
</html>