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
@WebServlet("/updateb")
public class UpdateBookDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b=new Book();
		BookDAO bdao=new BookDAOImp();
		b.setBid(Integer.parseInt(req.getParameter("bid")));
		System.out.println(req.getParameter("bid"));
		b.setTitle(req.getParameter("title"));
		b.setAuthor(req.getParameter("author"));
		b.setLanguage(req.getParameter("lan"));
		b.setYear(req.getParameter("year"));
		b.setPrice(Double.parseDouble(req.getParameter("price")));
		b.setStatus(req.getParameter("status"));
		if(bdao.updateBook(b))
		{
			req.setAttribute("success","update successfull");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("failure", "failed to update details");
			RequestDispatcher rd=req.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(req, resp);
		}
	}

}
