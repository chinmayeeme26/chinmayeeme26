package com.library.servlet;

import java.io.IOException;

import com.library.dto.Customer;
import com.library.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/update")
public class Update extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(false);
		Customer c=(Customer)session.getAttribute("s");
		CustomerDAO cdao=new CustomerDAOImp();
		
		c.setCname(req.getParameter("name"));
		c.setMail(req.getParameter("mail"));
		c.setPhone(Long.parseLong(req.getParameter("phone")));
		c.setAge(Integer.parseInt(req.getParameter("age")));
		if(cdao.updateCustomet(c))
		{
			req.setAttribute("success", "date updated sucessfully");
			RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
			
		}
		else
		{
			req.setAttribute("failure", "Failed to update data");
			RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
	}
	
}
