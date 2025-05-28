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
@WebServlet("/delete")
public class Delete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		CustomerDAO cdao=new CustomerDAOImp();
		c=cdao.getCustomet(Integer.parseInt(req.getParameter("cid")));
		if(cdao.deleteCustomet(c))
		{
			req.setAttribute("success", "data deleted successfully");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("failure", "failed to delete Data");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
	}
	
}
