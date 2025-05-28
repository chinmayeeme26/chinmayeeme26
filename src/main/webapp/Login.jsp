<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login page</title>
<style type="text/css">
	*{
	margin:0rem;
	padding:0rem;
	text-decoration:none;
	}
	body{
	background-image:url(https://static.vecteezy.com/system/resources/thumbnails/033/115/388/small_2x/learning-concept-open-textbook-in-a-library-with-academic-surroundings-ai-generated-photo.jpg);
	background-size:cover;
	background-attachment:fixed;
	background-repeat: no-repeat;
	color:white;
	}
	nav{
	height:3rem;
	width:100vw;
	background-color:rgb(0,0,0,0.7);
	color:white;
	font-size:2rem;
	text-align:center;
	}
	form{
	width:500px;
	height:300px;
	border:1px solid black;
	margin:25vh auto;
	text-align:center;
	background-color:rgba(0,0,0,0.5);
	padding-top:30px;
	border-radius:2%;
	box-sizing:border-box;
	}
	form a{
	color:white;
	}
	input[type="submit"]{
	padding:5px;
	border:none;
	outline:none;
	border-radius:3px;
	}
	.s{
	text-align:center;
	}
	.f{
	text-align:center;
	}
</style>
</head>
<body>
	<nav>
	<p>Welcome to Login Page</p>
	</nav>
	<form action="login" method="post"><br>
		Enter your Mail Id:<br>
		<input type="email" name="mail" placeholder="enter your Mail Id" required><br><br>
		Password:<br>
		<input type="password" name="pass" placeholder="password" required><br><br>
		<input type="submit" value="Login"><br><br>
		<a href="Forget.jsp">Forget password? </a>
		<a href="Signup.jsp">New User!</a>
	</form>
	<% String s=(String)request.getAttribute("s");
		if(s!=null){%>
		<h3 class="s"><%=s %></h3>
		<%}
		String f=(String)request.getAttribute("f");
		if(f!=null){%>
		<h3 class="f"><%=f %></h3>
	<%} %>
</body>
</html>