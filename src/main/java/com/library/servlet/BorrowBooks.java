package com.library.servlet;

import java.io.IOException;

import com.library.dto.Book;
import com.library.dto.Borrow;
import com.library.dto.Customer;
import com.library.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/borrow")
public class BorrowBooks extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b=new Book();
		Borrow br=new Borrow();
		HttpSession session=req.getSession(false);
		Customer c=(Customer)session.getAttribute("s");
		BookDAO bdao=new BookDAOImp();
		BorrowDAO brd=new BorrowDAOImp();
		CustomerDAO cdao=new CustomerDAOImp();
		b=bdao.getBook(Integer.parseInt(req.getParameter("bid")));
		b.setStatus("Borrowed");
		br.setBbid(b.getBid());
		br.setBcid(c.getCid());
		if(brd.insertIntoBorrow(br))
		{
			if(bdao.updateBook(b))
			{
				req.setAttribute("s","Book is ready to Borrow and recorded go and collect it in the library");
				RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("f", "failed to update Book data go and ask in Library");
				RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("f", "Failed to Borrow try again");
			RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
			rd.forward(req, resp);
		}
	}
	

}
