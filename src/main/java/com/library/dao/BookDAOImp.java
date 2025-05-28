package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.connection.Connector;
import com.library.dto.Book;
import com.library.dto.Customer;

public class BookDAOImp implements BookDAO{
	private Connection con;
	public BookDAOImp(){
		this.con=Connector.requestConnection();
	}
	@Override
	public boolean insertBook(Book b) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int res=0;
		String query="insert into book(title,author,language,year,price) values(?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getLanguage());
			ps.setString(4, b.getYear());
			ps.setDouble(5, b.getPrice());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0)
		{
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public boolean updateBook(Book b) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int res=0;
		String query="update book set title=?,author=?,language=?,year=?,price=?,status=? where bid=?";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1,b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getLanguage());
			ps.setString(4, b.getYear());
			ps.setDouble(5, b.getPrice());
			ps.setString(6, b.getStatus());
			ps.setInt(7, b.getBid());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0)
		{
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return true;
		}
		else
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return false;
		}
	}

	@Override
	public boolean deleteBook(Book b) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="delete from book where bid=?";
		int res=0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setInt(1, b.getBid());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0)
		{
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return true;
		}
		else
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return false;
		}
	}
	@Override
	public Book getBook(int Bid) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Book b=null;
		String query="select * from book where bid=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, Bid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Book();
				b.setBid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setLanguage(rs.getString(4));
				b.setYear(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setStatus(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Book getBook(String title) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Book b=null;
		String query="select * from book where title=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, title);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Book();
				b.setBid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setLanguage(rs.getString(4));
				b.setYear(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setStatus(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public ArrayList<Book> getBook(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs= null;
		ArrayList<Book> bl=new ArrayList<Book>();
		Book b=null;
		String query="";
		if(c.getCid()==1)
		{
			query="select * from book";
		}
		else {
			query="select * from book where status=?";
		}
		try {
			ps=con.prepareStatement(query);
			if(c.getCid()!=1)
			{
				ps.setString(1, "Avilable");
			}
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Book();
				b.setBid(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setLanguage(rs.getString(4));
				b.setYear(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				b.setStatus(rs.getString(7));
				bl.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bl;
	}

}
