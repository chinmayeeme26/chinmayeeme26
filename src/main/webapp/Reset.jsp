<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Pin</title>
<style type="text/css">
	*{
	margin:0;
	padding:0;
	text-decoration:none;
	}
	nav{
	background-color:rgba(0,0,0,0.7);
	height:1rem;
	display:flex;
	justify-content:space-between;
	padding:1rem;}
	nav a{
	font-size:1.5rem;
	color:white;
	}
	form{
	height:200px;
	width:250px;
	margin:3rem auto;
	background-color:rgba(0,0,0,0.1);
	border-radius:1rem;
	padding:3rem;
	box-shadow:0 0 1rem black;
	text-align:center;
	}
	h1{
	text-align:center;}
		.s{
	color:green;}
	.f{
	color:red;}
</style>
</head>
<body>
	<nav>
		<a href="#">Reset Page</a>
		<a href="Dashboard.jsp">DashBoard</a>
	</nav>
	<h1>Reset Password</h1><br>
	<form action="reset" method="post"><br>
		Password:<br>
		<input type="password" name="pass"><br><br>
		Confirm Password:<br>
		<input type="password" name="cpass"><br><br>
		<input type="submit" value="Reset">
	</form>
			<% String s=(String)request.getAttribute("success");
		if(s!=null){%>
		<h3 class="s"><%=s %></h3>
		<%}
		String f=(String)request.getAttribute("failure");
		if(f!=null){%>
		<h3 class="f"><%=f %></h3>
	<%} %>
</body>
</html>