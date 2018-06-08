<%@ page language="java" contentType="text/html"%>
<%@include file="adminlink.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {
	background-image: url("bg1.jpg");
	background-repeat:no-repeat;
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
	<center>
		<h3>${successMessage}${errorMessage}</h3>
	</center>
	<form action="AdminServlet" method="post">
		<input type="hidden" name="action" value="add_bus_type" />
		<center>
			<font color="#8710c1" size=5> Bus Type</font><input type="text"
				name="busType"></input>
		</center>
		<br> <br>
		<center>
			<input type="submit" value="submit">
		</center>
	</form>
	</div>
</body>
</html>
