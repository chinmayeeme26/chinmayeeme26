<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Books</title>
<style type="text/css">
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
	box-shadow:0 0 1rem rgba(0,0,0,0.7);
	border-radius:1rem;
	margin:2rem auto;
	height:450px;
	width:300px;
	text-align:center;
	background-color:rgba(0,0,0,0.3)}
	form p{
	font-size:1.5rem;}
</style>
</head>
<body>
	<%Book b=(Book)session.getAttribute("b"); %>
	<nav>
		<p>Welcome to Update Books</p>
		<a href="Books.jsp">Books</a>
	</nav>
	<form action="updateb" method="post">
		<p>Update Details</p><br>
		<input type="hidden" value="<%=b.getBid()%>" name="bid">
		Title:<br>
		<input type="text" placeholder="Title" name="title" value="<%=b.getTitle() %>"><br><br>
		Author:<br>
		<input type="text" placeholder="Author" name="author" value="<%=b.getAuthor() %>"><br><br>
		Language:<br>
		<input type="text" placeholder="Language" name="lan" value="<%=b.getLanguage() %>"><br><br>
		Year:<br>
		<input type="text" placeholder="Year" name="year" value="<%=b.getYear()%>"><br><br>
		Price:<br>
		<input type="number" placeholder="price" name="price" value="<%=b.getPrice()%>"><br><br>
		Status:<br>
		<input type="text" placeholder="status" name="status" value="<%=b.getStatus()%>"><br><br>
		<input type="submit" value="update">
	</form>
	<%String s=(String)request.getAttribute("success");
	if(s!=null){%>
	<h3><%=s %></h3>
	<%}String f=(String)request.getAttribute("failure");
	if(f!=null){%>
	<h3><%=f %></h3>
	<%} %>
</body>
</html>