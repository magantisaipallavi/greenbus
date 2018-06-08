<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List.*"%>
<%@page import="java.util.ArrayList.*"%>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	function checkLimit(j) {
		var count = 0;
		var seats = document.getElementsByName("seats");
		var lastSelected = document.getElementById(j).value;
		var x = parseInt(j,10) - 1;		
		for (var i = 0; i < seats.length; i++) {		
			if (seats[i].checked) {
				count++;				
			}
			if(count > 4) {
				document.form.seats[x].checked = false;
				alert("you can select 4 seats only");
				break;
			}
		}
	}
</script>

<style>
@import url("seatColoring.css");

@import url("seatLayout.css");

body {
	background-image: url("bg1.jpg");
	background-repeat:no-repeat;
}

</style>

</head>
<body>
	<form method="post" name=form action="HomeServlet">
		
		<%
			List<Integer> reservedSeatsList = (List<Integer>) request.getAttribute("reservedSeatNoList");
		%>
		<input type="hidden" name="action" value="get_reserved_seats" />

		<div class="centered">
		<center>
			
			<style="margin-top=600px">Cost :<h4><%=request.getAttribute("cost")%></h4></style></center>
			<div id="container">
	
				<div id="header">
					<div class="row">

						<%
							for (int i = 1; i <= 10; i++) {
								String j = "" + i;
								if (reservedSeatsList.contains(i)) {
						%>
						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox" disabled
								name="seats" id=<%=j%> value=<%=j%> onclick="checkLimit(<%=j%>)" />
								<block><%=j%></block></label>
						</div>

						<%
							} else {
						%>


						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox"
								name="seats" id=<%=j%> value=<%=j%> onclick="checkLimit(<%=j%>)" />
								<span><%=j%></span></label>
						</div>
						<%
							}
							}
						%>
					</div>
					<div class="row">
						<%
							for (int i = 1; i <= 10; i++) {
								String j = "" + (10 + i);
								if (reservedSeatsList.contains(i + 10)) {
						%>
						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox" disabled
								name="seats" id=<%=j%> value=<%=j%> onclick="checkLimit(<%=j%>)" />
								<block><%=j%></block></label>
						</div>

						<%
							} else {
						%>



						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox"
								name="seats" id=<%=j%> value=<%=j%> onclick="checkLimit(<%=j%>)" />
								<span><%=j%></span></label>
						</div>
						<%
							}
							}
						%>
					</div>
				</div>

				<div id="content">
					<div id="nav"></div>
					<div id="main">
						<div class="row">
							<%
								String j = "21";
								if (reservedSeatsList.contains(21)) {
							%>
							<div class="col-sm-1" style="background-color: lavenderblush;">
								<label class="checkbox"> <input type="checkbox" disabled
									name="seats" id=<%=j%> value=<%=j%>
									onclick="checkLimit(<%=j%>)" /> <block><%=j%></block></label>
							</div>

							<%
								} else {
							%>
							<div class="col-sm-1" style="background-color: lavenderblush;">
								<label class="checkbox"> <input type="checkbox"
									name="seats" id=<%=j%> value=<%=j%>
									onclick="checkLimit(<%=j%>)" /><span><%=j%></span></label>
							</div>
							<%
								}
							%>
						</div>

					</div>
				</div>
				<div id="footer">
					<div class="row">
						<%
							for (int i = 1; i <= 10; i++) {
								String k = "" + (21 + i);
								if (reservedSeatsList.contains(i + 21)) {
						%>
						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox" disabled
								name="seats" id=<%=k%> value=<%=k%> onclick="checkLimit(<%=k%>)" />
								<block><%=j%></block></label>
						</div>

						<%
							} else {
						%>

						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox"
								name="seats" id=<%=k%> value=<%=k%> onclick="checkLimit(<%=k%>)" />
								<span><%=k%></span></label>
						</div>
						<%
							}
							}
						%>
					</div>
					<div class="row">
						<%
							for (int i = 1; i <= 10; i++) {
								String k = "" + (31 + i);
								if (reservedSeatsList.contains(i + 31)) {
						%>
						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox" disabled
								name="seats" id=<%=k%> value=<%=k%> onclick="checkLimit(<%=k%>)" />
								<block><%=k%></block></label>
						</div>

						<%
							} else {
						%>
						<div class="col-sm-1" style="background-color: lavenderblush;">
							<label class="checkbox"> <input type="checkbox"
								name="seats" id=<%=k%> value=<%=k%> onclick="checkLimit(<%=k%>)" />
								<span><%=k%></span></label>
						</div>

						<%
							}
							}
						%>
					</div>
				</div>
				<div>
					<br>
					<center><br>
						<font color="#F08080" size=4>Blue - Available Seats</font>
					</center>
					<center>
						<font color="#F08080" size=4>Grey - Reserved Seats</font>
					</center>
					<center>
						<font color="#F08080" size=4>Green -Selected Seats</font>
					</center>
				</div>

				<center>
					<input type="submit" id="submit" value="submit" />
				</center>
			</div>
		</div>
	</form>
</body>
</html>