<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.dao.*" %>
<%@ page import="com.library.dto.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<style>
	*{
	margin:0;
	padding:0;
	text-decoration:none;
	}
	.borrowBuy
	{
	display:flex;
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
	.book{
	padding:1rem;
	box-shadow:0 0 10px rgba(0,0,0,0.5);
	margin:2rem;
	border-radius:1rem;
	}
	table{
	width:100%;
	text-align:left;
	background-color:rgba(0,0,0,0.5);
	}
	th{
	background-color:rgba(0,0,0,1);
	color:white;}
	caption{
	font-size:1.5rem;}
</style>
</head>
<body>
	<%Book b=new Book(); 
	BookDAO bdao=new BookDAOImp();
	Customer c=(Customer)session.getAttribute("s");%>
	<nav>
		<p>Welcome to Books</p>
		<a href="Dashboard.jsp">Dashbored</a>
	</nav>
	<%String s=(String)request.getAttribute("s");
		if(s!=null){%>
		<p><%=s %></p>
		<%}
		String f=(String)request.getAttribute("f");
		if(f!=null){%>
		<p><%=f %></p>
		<%}%>
	<div class="book">
		<table>
		<caption>Books</caption>
		<tr>
		<th>BID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Language</th>
		<th>Year</th>
		<th>price</th>
		<th>Status</th>
		<th>Borrow</th>
		<th>buy</th>
		<%if(c.getCid()==1){ %>
		<th>Update</th>
		<th>Delete</th>
		<%} %>
		</tr>
		<%ArrayList<Book> ar=bdao.getBook(c); 
		Iterator<Book> it=ar.iterator();
		while(it.hasNext()){
		b=it.next();%>
		<tr>
		<td><%=b.getBid() %></td>
		<td><%=b.getTitle() %></td>
		<td><%=b.getAuthor() %></td>
		<td><%=b.getLanguage() %></td>
		<td><%=b.getYear() %></td>
		<td><%=b.getPrice() %></td>
		<td><%=b.getStatus() %></td>
		<td><form action="borrow" method="post"><input type="hidden" value="<%=b.getBid() %>" name="bid"><input type="submit" value="Borrow"></form></td>
		<td><form action="buy" method="post"><input type="hidden" value="<%=b.getBid() %>" name="bid"><input type="submit" value="Buy"></form></td>
		<%if(c.getCid()==1){ %>
		<td><form action="updatebook" method="post"><input type="hidden" value="<%=b.getBid() %>" name="bid"><input type="submit" value="Update"></form></td>
		<td><form action="deletebook" method="post"><input type="hidden" value="<%=b.getBid() %>" name="bid"><input type="submit" value="Delete"></form></td>
		<%} %>
		</tr>
		<%} %>
		</table>
	</div>
</body>
</html>