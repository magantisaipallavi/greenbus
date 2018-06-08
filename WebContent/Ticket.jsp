<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>${successMessage}${errorMessage}</h3>
	</center>
	<form method="post" action="HomeServlet">
		<center>
			<input type="hidden" name="action" value="ticket" /> <font
				color="#8710c1" size=5>RegistrationNo</font>
		</center>
		<center>
			<input type="text" name="registrationNo" id="regno"
				placeholder="registrationNo" /><font color="#8710c1"
				size=5> RouteId</font>
		</center>
		<center>
			<input type="text" name="routeId" id="routeid" placeholder="RouteId" />
			<font color="#8710c1" size=5>Date</font>
		</center>
		<center>
			<input type="text" name="journeyDate" id="date" placeholder="date" />
			<font color="#8710c1" size=5>UserId</font>
		</center>
		<center>
			<input type="text" name="userId" id="userId" placeholder="userId" />
			<br>
			<center>
				<input type="submit" value="submit">
			</center>
	</form>
</body>
</html>