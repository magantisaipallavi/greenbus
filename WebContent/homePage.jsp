<!DOCTYPE html>
<html lang="en">
<head>
<title>Green Bus</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
@import url(generallayout.css);

.btn{
font-size:25px;
width:210px;
}

@import url(my.css);
</style>
<script>
	function call() {
		$("#main").load("HomeServlet/?action=show_route");
	}
</script>

</head>
<body>
<h3>${successMessage}${errorMessage}</h3>
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
								<a href="homePage.jsp"style="color:white">Home</a>
							</button>
							<button type="button" class="btn btn-success">
								<a href="Aboutus.html"style="color:white">About Us</a>
							</button>
							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#myModal">Sign Up</button>
							<div class="modal fade" id="myModal" role="dialog">
								<div class="modal-dialog modal-sm">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Sign Up</h4>
										</div>
										<div class="modal-body">
											<p>

												<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
												<html>
<head>
<style>
@import
url(my.css)
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="HomeServlet" method = "post">
	 <input type="hidden" name="action" value="signup" />
		<input type="text" name="username" id="username"
			placeholder="username" required></input><br> <br> <input
			type="password" name="password" id="password" placeholder="password"
			required></input><br> <br> <input type="text"
			name="emailid" id="emailid" placeholder="emailid" required></input><br>
		<br> <input type="text" name="phno" id="phno"
			placeholder="phone number" required
			onkeypress='return event.charCode >= 48 && event.charCode <= 57'></input>
		<br> <span id="msg"></span> <input type="submit" value="Sign Up"
			name="action" name="submit"></input>
	</form>
</body>
												</html>




											</p>
										</div>

									</div>
								</div>
							</div>
							<div class="btn-group">
								<button type="button" class="btn btn-success  dropdown-toggle"
									data-toggle="dropdown">
									Login <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<button type="button" class="btn btn-default btn-xs"
										data-toggle="modal" data-target="#myModal1">Admin</button>
									<br>
									<button type="button" class="btn btn-default btn-xs"
										data-toggle="modal" data-target="#myModal2">User</button>
								</ul>
								<!-- Modal 1-->
								<div class="modal fade" id="myModal1" role="dialog">
									<div class="modal-dialog modal-sm">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Admin</h4>
											</div>
											<div class="modal-body">
												<p>

													<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
													<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import
url(my.css)
</style>

</head>
<body>
	<form action="AdminServlet" method=post>
		<br> <input type="hidden" name="action" value="adminlogin" />
		<center>
			<input type="text" name="emailid" id="emailid" placeholder="emailid"
				required></input><br> <br>
		</center>
		<center>
			<input type="password" name="password" id="password"
				placeholder="password" required></input>
		</center>
		<span id="msg"></span> <input type="submit" name="action" id="submit"
			value="Log in"></input> <br>
	</form>
</body>
													</html>

												</p>
											</div>

										</div>

									</div>
								</div>
								<!-- Modal 2-->
								<div class="modal fade" id="myModal2" role="dialog">
									<div class="modal-dialog modal-sm">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">User</h4>
											</div>
											<div class="modal-body">
												<p>

													<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
													<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import
url(my.css)
</style>
</head>
<body>
	<form method="post" action="HomeServlet">
		<br><input type="hidden" name="action" value="userlogin" />
		<center>
			<input type="text" name="emailid" id="emailid" placeholder="emailid"
				required></input><br> <br>
		</center>
		<center>
			<input type="password" name="password" id="password"
				placeholder="password" required></input>
		</center>
		<span id="msg"></span> <input type="submit" value="Log in"
			name="action" id="submit"></input> <br>
	</form>
</body>
													</html>



												</p>
											</div>

										</div>

									</div>
								</div>




							</div>

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
		</table>
		<div class="w3-content w3-section" id="main">
			<img class="mySlides" src="gbus.jpg" id="im" width="1400px"
				height="700px"> <img class="mySlides" src="image2.jpg" id="im"
				width="1400px" height="700px"> <img class="mySlides"
				src="bus7.jpg" id="im" width="1400px" height="700px">
		</div>
		<script>
			var myIndex = 0;
			carousel();

			function carousel() {
				var i;
				var x = document.getElementsByClassName("mySlides");
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				myIndex++;
				if (myIndex > x.length) {
					myIndex = 1
				}
				x[myIndex - 1].style.display = "block";
				setTimeout(carousel, 2000); // Change image every 2 seconds
			}
		</script>

		<div id="footer">
			<h3>Copyrights reserved</h3>
			<br> <br> <br>
		</div>
	</div>
	</div>
</body>
</html>


