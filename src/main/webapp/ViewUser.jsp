<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.library.dao.*"
    import="com.library.dto.*" 
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers Details</title>
<style type="text/css">
	*{
	margin:0;
	paddin:0;
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
	table{
	width:100%;
	text-align:left;
	background-color:rgba(0,0,0,0.5);
	}
	th{
	background-color:rgba(0,0,0,1);
	color:white;
	}
	.users{
	padding:1rem;
	box-shadow:0 0 10px rgba(0,0,0,0.5);
	margin:2rem;
	border-radius:1rem;
	}
	caption{
	font-size:1.5rem;}
</style>
</head>
<body>
	<%String s=(String)request.getAttribute("success");
		if(s!=null){%>
		<p><%=s %></p>
		<%}
		String f=(String)request.getAttribute("failure");
		if(f!=null){%>
		<p><%=f %></p>
		<%}%>
	<nav>
	<p>Users Details</p>
	<a href="Dashboard.jsp">Dashboard</a>
	</nav>
	<div class="users">
	<table>
	<caption>Users Details</caption>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Mail</th>
		<th>phone</th>
		<th>Age</th>
		<th>Due</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<%Customer c=new Customer();
	CustomerDAO cdao=new CustomerDAOImp();
	ArrayList<Customer> ar=cdao.getCustomer();
	Iterator<Customer> it=ar.iterator();
	while(it.hasNext()){
	c=it.next();%>
	<tr>
		<td><%=c.getCid() %></td>
		<td><%=c.getCname() %></td>
		<td><%=c.getMail() %></td>
		<td><%=c.getPhone() %></td>
		<td><%=c.getAge() %></td>
		<td><%=c.getDue() %></td>
		<td><form action="UpdateCust.jsp" method="post"><input type="hidden" name="cid" value="<%=c.getCid()%>"><input type="submit" value="update"></form></td>
		<td><form action="delete" method="post"><input type="hidden" name="cid" value="<%=c.getCid()%>"><input type="submit" value="delete"></form></td>
	</tr>
	<%} %>
	</table>
	</div>
</body>
</html>