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
@WebServlet("/deletebook")
public class DeleteBook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b=new Book();
		BookDAO bdao=new BookDAOImp();
		b=bdao.getBook(Integer.parseInt(req.getParameter("bid")));
		if(bdao.deleteBook(b))
		{
			req.setAttribute("s", "Book deleted successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("f", "Failed to delet the Book");
			RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
			rd.forward(req, resp);
		}
	}

}
