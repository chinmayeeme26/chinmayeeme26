<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.library.dao.*"
    import="com.library.dto.*"
    import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrowed Details</title>
<style type="text/css">
	*{
	margin:0;
	paddin:0;
	text-decoration:none;}
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
	.books
	{
	box-shadow:0 0 10px rgba(0,0,0,0.7);
	border-radius:1rem;
	padding:1rem;
	margin:2rem;
	}
	table{
	width:100%;
	text-align:left;
	background-color:rgba(0,0,0,0.5);
	}
	th{
	background-color:rgba(0,0,0,1);
	color:white;
	}
	caption{
	font-size:1.5rem;
	}
</style>
</head>
<body>
<nav>
	<p>Borrowed Details</p>
	<a href="Dashboard.jsp">Dashboard</a>
	</nav>
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
	ArrayList<Borrow> a=bdao.getBorrow();
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
</body>
</html>