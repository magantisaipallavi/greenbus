<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
@import url(generallayout.css);

@import url(my.css);

body {
	background-image: url("bg1.jpg");
	background-repeat: no-repeat;
}

.btn {
	width: 360px;
	font-size: 30px;
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
</style>
</head>
<body>
	<div id="container">
		<table style="background-color: green">
			<div id="header">
				<div id="header1">
					<tr>
						<td><img class="img-thumbnail" src="logo.jpg" width=100px>
						</td>
				</div>
				<td>
					<div id="header2">
						<div class="btn-group">



							<button type="button" class="btn btn-success">
								<a
									href="HomeServlet?action=logout"
									style="color: white">Log out</a>
							</button>
							<button type="button" class="btn btn-success">
								<a
									href="HomeServlet?action=search_form"
									style="color: white">Search Buses</a>
							</button>
							<div class="btn-group">
								<button type="button" class="btn btn-success dropdown-toggle"
									data-toggle="dropdown">
									Contact Us <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li>Vijaywada-9078564534</li>
									<li>Chennai-9067564534</li>
									<li>bangalore-9078568900</li>
									<li>Vizag-9078564123</li>
									<li>Guntur-9078523148</li>
									<li>Hyderabad-9078564534</li>
								</ul>
							</div>
						</div>

					</div>
				</td>
				</tr>
			</div>
		</table>

		<div class="centered">
			
				<center>
		<h1>${successMessage}${errorMessage}</h1>
		
	</center>
		</div>
	</div>


</body>
</html>