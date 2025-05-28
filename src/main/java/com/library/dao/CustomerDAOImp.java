package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.connection.Connector;
import com.library.dto.Customer;

public class CustomerDAOImp implements CustomerDAO{

	private Connection con;
	public CustomerDAOImp()
	{
		this.con=Connector.requestConnection();
	}
	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String queary ="insert into customer(cname,mail,phone,age,password) values(?,?,?,?,?)";
		int res=0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(queary);
			ps.setString(1,c.getCname());
			ps.setString(2, c.getMail());
			ps.setLong(3,c.getPhone());
			ps.setInt(4, c.getAge());
			ps.setString(5,c.getPassword());
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
	public Customer getCustomer(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="select * from customer where mail=? and password=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2,password);
			rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setMail(rs.getString(4));
				c.setPhone(rs.getLong(3));
				c.setAge(rs.getInt(5));
				c.setDue(rs.getDouble(6));
				c.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomer(long phone, String mail) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="select * from customer where phone=? and mail=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,phone);
			ps.setString(2,mail);
			rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setMail(rs.getString(4));
				c.setPhone(rs.getLong(3));
				c.setAge(rs.getInt(5));
				c.setDue(rs.getDouble(6));
				c.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomet(int cid) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="select * from customer where cid=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, cid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setMail(rs.getString(4));
				c.setPhone(rs.getLong(3));
				c.setAge(rs.getInt(5));
				c.setDue(rs.getDouble(6));
				c.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<Customer> getCustomer() {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Customer> cl=new ArrayList<Customer>();
		Customer c=null;
		String query="select * from customer";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Customer();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setMail(rs.getString(4));
				c.setPhone(rs.getLong(3));
				c.setAge(rs.getInt(5));
				c.setDue(rs.getDouble(6));
				c.setPassword(rs.getString(7));
				cl.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public boolean updateCustomet(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int res=0;
		String q="update customer set cname=?,mail=?,phone=?,age=?,due=?,password=? where cid=?";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(q);
			ps.setString(1, c.getCname());
			ps.setString(2, c.getMail());
			ps.setLong(3, c.getPhone());
			ps.setInt(4, c.getAge());
			ps.setDouble(5, c.getDue());
			ps.setString(6, c.getPassword());
			ps.setInt(7, c.getCid());
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
	public boolean deleteCustomet(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int res=0;
		String query="delete from customer where cid=?";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setInt(1,c.getCid());
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
			}return false;
		}
	}

}
