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
@WebServlet("/reset")
public class Reset extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(false);
		Customer c=(Customer) session.getAttribute("s");
		CustomerDAO cdao =new CustomerDAOImp();
		if((req.getParameter("pass")).equals(req.getParameter("cpass")))
		{
			c.setPassword(req.getParameter("pass"));
			if(cdao.updateCustomet(c))
			{
				req.setAttribute("success","password reset successfull");
				RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("failure", "failed to reset password");
				RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("failure", "missmatch password");
			RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
			rd.forward(req, resp);
		}
	}
	
}
