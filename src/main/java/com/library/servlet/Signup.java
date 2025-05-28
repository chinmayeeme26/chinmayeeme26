package com.library.servlet;

import java.io.IOException;
import com.library.dao.*;
import com.library.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDAO cdao=new CustomerDAOImp();
		Customer c=new Customer();
		c.setCname(req.getParameter("name"));
		c.setMail(req.getParameter("mail"));
		c.setPhone(Long.parseLong(req.getParameter("phone")));
		c.setAge(Integer.parseInt(req.getParameter("age")));
		if(req.getParameter("pass").equals(req.getParameter("cpass")))
		{
			c.setPassword(req.getParameter("pass"));
			if(cdao.insertCustomer(c))
			{
				req.setAttribute("s", "Account created Sucessfully");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("f","Failed to create an account try again");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("f","Password Missmatch");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}
	}
	
}
