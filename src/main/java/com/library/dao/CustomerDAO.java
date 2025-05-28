package com.library.dao;

import java.util.ArrayList;

import com.library.dto.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer c);//Signup
	public Customer getCustomer(String mail,String password);//login
	public Customer getCustomer(long phone,String mail);//Reset pass
	public Customer getCustomet(int cid);//customer
	public ArrayList<Customer> getCustomer();//admin
	public boolean updateCustomet(Customer c);//customer
	public boolean deleteCustomet(Customer c);//admin
}
