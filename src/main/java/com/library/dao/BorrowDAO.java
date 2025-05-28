package com.library.dao;

import java.util.ArrayList;

import com.library.dto.Book;
import com.library.dto.Borrow;
import com.library.dto.Customer;

public interface BorrowDAO {
	public boolean insertIntoBorrow(Borrow br);
	public boolean updateBorrow(Borrow br);
	public Borrow getBorrowfromlast();
	public ArrayList<Borrow> getBorrow();
	public ArrayList<Borrow> getBorrow(int bcid);
}
