<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Book</title>
<style>
	*{
	margin:0;
	padding:0;
	text-decoration:none;
	}
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
	height:450px;
	width:350px;
	margin:10vh auto;
	background-color:rgba(0,0,0,0.3);
    text-align: center;
    border-radius: 2%;
    padding-top:20px;
	}
</style>
</head>
<body>
	<nav>
		<p>Insert Book</p>
		<a href="Dashboard.jsp">Dashboard</a>
	</nav>
	<form action="insert" method="post"><br>
	<caption>Book Details</caption><br><br>
		Enter your Title:<br>
		<input type="text" name="title" placeholder="Title" required><br><br>
		Enter the Author:<br>
		<input type="text" name="author" placeholder="Author" required><br><br>
		Enter the Language:<br>
		<input type="text" name="lan" placeholder="language" required><br><br>
		Enter the Year:<br>
		<input type="text" name="year" placeholder="year" required><br><br>
		Enter the price:<br>
		<input type="text" name="price" placeholder="price" required><br><br>
		<input type="submit" value="Insert"><br>
	</form>
	<%String s=(String)request.getAttribute("s");
		if(s!=null){%>
		<p><%=s%></p>
		<%}
		String f=(String)request.getAttribute("f");
		if(f!=null){%>
		<p><%=f%></p>
		<%}%>
</body>
</html>