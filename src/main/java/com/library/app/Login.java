package com.library.app;

import com.library.dto.Customer;

import java.util.Scanner;

import com.library.dao.*;
public class Login {

	public static void login() {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		CustomerDAO cdao=new CustomerDAOImp();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the mail ID");
		String mail=sc.next();
		System.out.println("Enter the password");
		String pass=sc.next();
		c=cdao.getCustomer(mail, pass);
		if(c!=null)
		{
			if(c.getCid()==1)
			{
				System.out.println("Welcome Admin"+c.getCname());
				Admin.admin(c);
			}
			else
			{
				System.out.println("welcome"+c.getCname());
				App.options(c);
			}
		}
		else
			System.out.println("Failed to login");
	}

}
