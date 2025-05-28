<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Signup page</title>
<style>
	*{
	margin:0rem;
	padding:0rem;
	text-decoration:none;
	}
	body{
	background-image:url(https://images2.minutemediacdn.com/image/upload/c_fill,w_720,ar_16:9,f_auto,q_auto,g_auto/shape/cover/sport/611949-gettyimages-909157366-0fd7262a4a9053972465d9449274e74a.jpg);
	background-size:cover;
	background-attachment:fixed;
	background-repeat:no-repeat;
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
	height:450px;
	width:350px;
	margin:10vh auto;
	background-color:rgba(0,0,0,0.5);
    text-align: center;
    border-radius: 2%;
    padding-top:20px;
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
	.f{
	text-align:center;
	}
</style>
</head>
<body>
		<nav>Welcome to Sign up page</nav>
	<form action="signup" method="post"><br>
		Enter your name:<br>
		<input type="text" name="name" placeholder="name" required><br><br>
		Enter the Mail Id:<br>
		<input type="email" name="mail" placeholder="MAIL ID" required><br><br>
		Enter the phone number:<br>
		<input type="tel" name="phone" placeholder="phone" required><br><br>
		Enter the Age:<br>
		<input type="number" name="age" placeholder="Age" required><br><br>
		Enter the password:<br>
		<input type="password" name="pass" placeholder="password" required><br><br>
		Confirm the password:<br>
		<input type="password" name="cpass" placeholder="confirm password" required><br><br>
		<input type="submit" value="create accont"><br>
		<a href="Login.jsp">already have a account?</a>
	</form>
		<%String f=(String)request.getAttribute("f"); %>
		<%if(f!=null){ %>
		<h3 class="f"><%=f %></h3>
		<%} %>
</body>
</html>