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
@WebServlet("/buy")
public class Buy extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b=new Book();
		BookDAO bdao=new BookDAOImp();
		Borrow br=new Borrow();
		BorrowDAO brd=new BorrowDAOImp();
		CustomerDAO cdao=new CustomerDAOImp();
		HttpSession session =req.getSession(false);
		Customer c=(Customer) session.getAttribute("s");
		b=bdao.getBook(Integer.parseInt(req.getParameter("bid")));
		b.setStatus("Sold");
		br.setBbid(b.getBid());
		br.setBcid(c.getCid());
		br.setBstatus("Bought");
		c.setDue(c.getDue()+b.getPrice());
		if(b!=null && brd.insertIntoBorrow(br) && bdao.updateBook(b)&& cdao.updateCustomet(c)&& brd.updateBorrow(brd.getBorrowfromlast()))
		{
				req.setAttribute("s","Book bought Successfully go and collect it at the library and clear the book price");
				RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
				rd.forward(req,resp);
		}
		else
		{
			req.setAttribute("f", "Failed to buy the book try again");
			RequestDispatcher rd=req.getRequestDispatcher("Books.jsp");
			rd.forward(req, resp);
		}
	}
}
