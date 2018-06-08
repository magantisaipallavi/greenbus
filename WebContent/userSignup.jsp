<%@ page language="java" contentType="text/html" import = "com.svecw.greenbus.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
@import url(design.css)
</style>
<script>
function validation(){
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var emailid = document.getElementById("emailid");
	var phno = document.getElementById("phno");
	if(username.value==""||password.value==""||emailid.value==""||phno.value==""){
		msg.innerHTML = "<font color = red>please fill all the details</font>"
		return false;
	}
	return true;
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<center><h3>${successMessage}${errorMessage}</h3></center>
<form  onsubmit = "return validation()" action="HomeServlet" method="post">
	<input type = "hidden" value = "signup" name = "action" ></input>
	<center>user name
	<input type = "text" name ="username" id ="username" placeholder = "username"></input></center><br><center>password
	<input type = "password" name ="password" id ="password" placeholder = "password"></input></center><br><center>e-mail id
	<input type = "text" name ="emailid" id ="emailid" placeholder = "emailid"></input></center><br><center>phone number
	<input type = "text" name ="phno" id ="phno" placeholder = "phone number" onkeypress='return event.charCode >= 48 && event.charCode <= 57 && event.charCode =08'></input></center>
	<br>
	<span id = "msg"></span>
	<center><input type = "submit" name = "submit" id = "submit" ></input></center>
</form>
</body>
</html>