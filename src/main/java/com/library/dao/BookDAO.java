package com.library.dao;

import java.util.ArrayList;

import com.library.dto.Book;
import com.library.dto.Customer;

public interface BookDAO {
	public boolean insertBook(Book b); //admin
	public boolean updateBook(Book b); //admin
	public boolean deleteBook(Book b); //admin
	public Book getBook(int Bid);	//while customer is searching for book
	public Book getBook(String name); // while customer is  searching the books
	public ArrayList<Book> getBook(Customer c); //admin
	
}
