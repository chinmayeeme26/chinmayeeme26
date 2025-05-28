<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.dto.*" 
import="com.library.dao.*"
import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
	*{
	margin:0;
	paddig:0;
	text-decoration:none;
	}
	nav{
	display:flex;
	height:3rem;
	color:white;
	background-color:rgb(0,0,0,0.5);
	justify-content:space-around;
	text-align:center;
	padding-top:0.8rem;
	font-size:1.2rem;
	box-sizing:border-box;
	}
	nav p{
	font-size:1.5rem;
	}
	nav a{
	color:white;}
	input[type="submit"]{
	padding:5px;
	border:none;
	outline:none;
	border-radius:3px;
	color:white;
	background-color:red;
	border-radius:3rem;
	}
	table{
	width:40vw;
	text-align:left;
	background-color:rgba(0,0,0,0.5);
	}
	.dashboard{
	display:flex;
	padding:2rem;
	gap:2rem;
	justify-content:space-around;
	}
	
	th{
	text-align:left;
	background-color:rgba(0,0,0,1);
	color:white;}
	td{
	padding-right:1rem;}
	.details{
	width:60vw;}
	.books
	{
	box-shadow:0 0 10px rgba(0,0,0,0.7);
	border-radius:1rem;
	padding:1rem;}
	.detalis
	{
	box-shadow:0 0 10px rgba(0,0,0,0.7);
	border-radius:1rem;
	padding:1rem;}
</style>
</head>
<body>
	<% Customer c=(Customer)session.getAttribute("s"); %>
	<nav>
	<p>Welcome <%=c.getCname() %></p>
	<a href="#"></a>
	<%if(c.getCid()==1){ %>
	<a href="Insert.jsp">Insert Books</a>
	<a href="ViewUser.jsp">View Users</a>
	<a href="Borrow.jsp">Borrow Details</a><%} %>
	<a href="Books.jsp">Books</a>
	<a href="Update.jsp">Update</a>
	<a href="Reset.jsp">Reset Pin</a>
	<form action="logout" method="post"><input type="submit" value="Logout"></form>
	</nav>
	
	<div class="dashboard">
	<div class="detalis">
	<table>
	<caption>User Details</caption>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Mail</th>
		<th>phone</th>
		<th>Age</th>
		<th>Due</th>
	</tr>
	<tr>
		<td><%=c.getCid() %></td>
		<td><%=c.getCname() %></td>
		<td><%=c.getMail() %></td>
		<td><%=c.getPhone() %></td>
		<td><%=c.getAge() %></td>
		<td><%=c.getDue() %></td>
	</tr>
	</table>
	</div>
	<div class="books">
	<table>
	<caption>Histroy</caption>
	<tr>
		<th>BorrowID</th>
		<th>BookID</th>
		<th>BorrowDate</th>
		<th>Bstatus</th>
		<th>Btime</th>
	</tr>
	<%Borrow br=new Borrow();
	BorrowDAO bdao=new BorrowDAOImp();
	ArrayList<Borrow> a=bdao.getBorrow(c.getCid());
	Iterator<Borrow> it=a.iterator();
	while(it.hasNext()){
		br=it.next();
	%>
	<tr>
		<td><%=br.getBrid() %></td>
		<td><%=br.getBrid() %></td>
		<td><%=br.getBod() %></td>
		<td><%=br.getBstatus() %></td>
		<td><%=br.getBtime() %></td>
	</tr>
	<%} %>
	</table>
	</div>
	</div>
</body>
</html>