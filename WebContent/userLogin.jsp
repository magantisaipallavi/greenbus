<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import url(design.css)
</style>
<script>
function validation(){

	var password = document.getElementById("password");
	var emailid = document.getElementById("emailid");

	if(password.value==""||emailid.value==""){
		msg.innerHTML = "<font color = red>please fill all the details</font>"
		return false;
	}
	return true;
}
</script>
</head>
<body>
<center><h3>${successMessage}${errorMessage}</h3></center>
<form onsubmit="return validation()" action = "http://localhost:8080/greenbus/HomeServlet" method="post">
<input type = "hidden" value = "login" name = "action" ></input>
<br><center>e-mail id
	<input type = "text" name = "emailid" id = "emailid" placeholder = "emailid"></input><br></center><center>password
<input type = "password" name = "password" id = "password" placeholder = "password"></input></center>
<span id = "msg"></span>
<input type = "submit" name = "submit" id = "submit" value = "submit" ></input>
<br>
</form>
</body>
</html>