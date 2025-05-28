package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.connection.Connector;
import com.library.dto.Borrow;

public class BorrowDAOImp implements BorrowDAO{
	private Connection con;
	public BorrowDAOImp()
	{
		this.con=Connector.requestConnection();
	}
	@Override
	public boolean insertIntoBorrow(Borrow br) {
		PreparedStatement ps=null;
		int res=0;
		String query="insert into Borrow (cid,bid,dob,btime) values(?,?,curdate(),datediff(dob,curdate()))";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setInt(1, br.getBcid());
			ps.setInt(2, br.getBbid());
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
	public boolean updateBorrow(Borrow br) {
		PreparedStatement ps=null;
		String q="update borrow set cid=?,bid=?,dob=?,bstatus=?,btime=? where brid=?";
		int res=0;
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(q);
			ps.setInt(1, br.getBcid());
			ps.setInt(2, br.getBbid());
			ps.setDate(3,br.getBod());
			ps.setString(4, br.getBstatus());
			ps.setInt(5, br.getBtime());
			ps.setInt(6, br.getBrid());
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
	public Borrow getBorrowfromlast() {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String q="select * from Borrow order by brid desc limit 1";
		Borrow b=null;
		ResultSet rs=null;
		int res=0;
		try {
			ps=con.prepareStatement(q);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Borrow();
				b.setBrid(rs.getInt(1));
				b.setBcid(rs.getInt(2));
				b.setBbid(rs.getInt(3));
				b.setBod(rs.getDate(4));
				b.setBstatus(rs.getString(5));
				b.setBtime(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public ArrayList<Borrow> getBorrow() {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Borrow b=null;
		ArrayList<Borrow> a=new ArrayList<Borrow>();
		String q="select * from borrow";
		try {
			ps=con.prepareStatement(q);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Borrow();
				b.setBrid(rs.getInt(1));
				b.setBcid(rs.getInt(2));
				b.setBbid(rs.getInt(3));
				b.setBod(rs.getDate(4));
				b.setBstatus(rs.getString(5));
				b.setBtime(rs.getInt(6));
				a.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public ArrayList<Borrow> getBorrow(int bcid) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Borrow b=null;
		ArrayList<Borrow> a=new ArrayList<Borrow>();
		String q="select * from borrow where cid=?";
		try {
			ps=con.prepareStatement(q);
			ps.setInt(1, bcid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				b=new Borrow();
				b.setBrid(rs.getInt(1));
				b.setBcid(rs.getInt(2));
				b.setBbid(rs.getInt(3));
				b.setBod(rs.getDate(4));
				b.setBstatus(rs.getString(5));
				b.setBtime(rs.getInt(6));
				a.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
