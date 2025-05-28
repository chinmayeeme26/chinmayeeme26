<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.library.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style type="text/css">
	*{
	margin:0;
	padding:0;
	text-decoration:none;
	}
	nav{
	display:flex;
	background-color:rgba(0,0,0,0.8);
	color:white;
	text-align center;
	justify-content:space-between;
	box-sizing:border-box;
	padding:1rem;
	}
	nav a{
	color:white;
	}
	p{
	font-size:1.5rem;
	}
	form{
	height:350px;
	width:200px;
	margin:3rem auto;
	background-color:rgba(0,0,0,0.1);
	border-radius:1rem;
	padding:3rem;
	box-shadow:0 0 1rem black;
	text-align:center;
	}
	.s{
	color:green;}
	.f{
	color:red;}
</style>
</head>
<body>
	<%Customer c=(Customer)session.getAttribute("s"); %>
	<nav>
		<p>Welcome to Update Page</p>
		<a href="Dashboard.jsp">Dashboard</a>
	</nav>
	<form action="update" method="post">
		<p>Update Details</p><br><br>
		UserName:
		<input type="text" placeholder="UserName" name="name" value="<%=c.getCname() %>"><br><br>
		Mail:
		<input type="email" placeholder="Mail" name="mail" value="<%=c.getMail()%>"><br><br>
		Phone:
		<input type="tel" placeholder="contact" name="phone" value="<%=c.getPhone() %>"><br><br>
		Age:
		<input type="number" placeholder="Age" name="age" value="<%=c.getAge()%>"><br><br>
		<input type="submit" value="update">
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