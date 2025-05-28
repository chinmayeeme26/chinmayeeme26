package com.library.app;

import java.util.Scanner;

import com.library.dto.Customer;
import com.library.dao.*;
public class Signup {

	public static void signup() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Customer c=new Customer();
		CustomerDAO cdao=new CustomerDAOImp();
		System.out.println("enter the cname");
		c.setCname(sc.next());
		System.out.println("enter the mailId");
		c.setMail(sc.next());
		System.out.println("enter the phone number");
		c.setPhone(sc.nextLong());
		System.out.println("Enter the age of the customer");
		c.setAge(sc.nextInt());
		System.out.println("enter the password");
		String pass=sc.next();
		System.out.println("confirm password");
		String cpass=sc.next();
		if(pass.equals(cpass))
		{
			c.setPassword(cpass);
			if(cdao.insertCustomer(c))
			{
				System.out.println("Signup sucessfull");
				System.out.println(c);
			}
			else
			{
				System.out.println("failed to signup");
			}
		}
		else
		{
			System.out.println("password Missmatch");
		}
	}

}
