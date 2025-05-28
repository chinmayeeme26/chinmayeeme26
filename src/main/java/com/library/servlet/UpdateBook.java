package com.library.servlet;

import java.io.IOException;

import com.library.dto.Book;
import com.library.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/updatebook")
public class UpdateBook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b=new Book();
		BookDAO bdao=new BookDAOImp();
		HttpSession session=req.getSession(false);
		b=bdao.getBook(Integer.parseInt(req.getParameter("bid")));
		if(b!=null)
		{
			
			session.setAttribute("b", b);
			RequestDispatcher rd=req.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("failure","Failed to update");
			RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
			rd.forward(req, resp);
		}
		
	}
	

}
