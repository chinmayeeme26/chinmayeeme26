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
@WebServlet("/insert")
public class Insert extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b=new Book();
		BookDAO bdao=new BookDAOImp();
		b.setTitle(req.getParameter("title"));
		b.setAuthor(req.getParameter("author"));
		b.setLanguage(req.getParameter("lan"));
		b.setYear(req.getParameter("year"));
		b.setPrice(Double.parseDouble(req.getParameter("price")));
		if(bdao.insertBook(b))
		{
			req.setAttribute("s", "Book inserted Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Insert.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("f", "Failed to insert Book");
			RequestDispatcher rd=req.getRequestDispatcher("Insert.jsp");
			rd.forward(req, resp);
		}
	}
}
