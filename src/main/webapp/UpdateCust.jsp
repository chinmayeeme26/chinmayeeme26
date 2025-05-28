<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.library.dao.*"
    import="com.library.dto.*" 
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer details</title>
<style>
	*{
	margin:0;
	padding:0;
	text-decoration:none;
	}
	nav p,nav a{
	font-size:1.5rem;
	font-weight:100;}
	nav
	{
	padding:0.5rem;
	box-sizing:border-box;
	display:flex;
	justify-content:space-between;
	text-alin:center;
	height:5vh;
	color:white;
	background-color:rgba(0,0,0,0.7);
	}
	nav a{
	color:white;}
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
	<%Customer c1=new Customer();
	CustomerDAO cdao=new CustomerDAOImp();
	c1=cdao.getCustomet(Integer.parseInt(request.getParameter("cid")));%>
	<nav>
	<p>Users Details</p>
	<a href="ViewUser.jsp">View Users</a>
	</nav>
	<form action="updatecust" method="post">
		<p>Update Details</p><br><br>
		<input type="hidden" name="cid" value="<%=c1.getCid()%>">
		UserName:
		<input type="text" placeholder="UserName" name="name" value="<%=c1.getCname() %>"><br><br>
		Mail:
		<input type="email" placeholder="Mail" name="mail" value="<%=c1.getMail()%>"><br><br>
		Phone:
		<input type="tel" placeholder="contact" name="phone" value="<%=c1.getPhone() %>"><br><br>
		Age:
		<input type="number" placeholder="Age" name="age" value="<%=c1.getAge()%>"><br><br>
		Due:
		<input type="tel" placeholder="Due" name="due" value="<%=c1.getDue()%>"><br><br>
		<input type="submit" value="update">
	</form>
</body>
</html>