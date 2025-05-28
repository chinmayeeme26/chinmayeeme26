package com.library.servlet;

import java.io.IOException;

import com.library.dao.CustomerDAO;
import com.library.dao.CustomerDAOImp;
import com.library.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/updatecust")
public class UpdateCust extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerDAO cdao=new CustomerDAOImp();
		Customer c=cdao.getCustomet(Integer.parseInt(req.getParameter("cid")));
		c.setCname(req.getParameter("name"));
		c.setMail(req.getParameter("mail"));
		c.setPhone(Long.parseLong(req.getParameter("phone")));
		c.setAge(Integer.parseInt(req.getParameter("age")));
		c.setDue(Double.parseDouble(req.getParameter("due")));
		if(cdao.updateCustomet(c))
		{
			req.setAttribute("success","Date updated successfully");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("failure","failed to update try again");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
	}

}
