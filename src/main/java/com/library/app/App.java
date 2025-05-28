package com.library.app;

import java.util.Scanner;

import com.library.dto.Customer;
import com.library.dao.*;
public class App {

	public static void options(Customer c) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDAOImp();
		BookDAO bdao=new BookDAOImp();
		int ch=0;
		do {
			System.out.println("Welcome to user options");
			System.out.println("1. search for book");
			System.out.println("2. show user detailes");
			System.out.println("3. show avaliable books");
			System.out.println("4. update detalis");
			System.out.println("5. thank for visiting");
			System.out.println("enter your choice");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the book your searching");
				bdao.getBook(sc.next());
				break;
			case 2:
				System.out.println(c);
				break;
			case 3:
				bdao.getBook(c);
				break;
			case 4:
				int sw=0;
				do {
					System.out.println("welcome to update page");
					System.out.println("1. update name");
					System.out.println("2. update mail");
					System.out.println("3. update phone");
					System.out.println("4. update age");
					System.out.println("5. update password");
					System.out.println("6. exit");
					sw=sc.nextInt();
					switch(sw)
					{
					case 1:
						System.out.println("Enter the new name");
						c.setCname(sc.next());
						if(cdao.updateCustomet(c))
						{
							System.out.println("updated sucessfully");
						}
						else
						{
							System.out.println("falied to update");
						}
						break;
					case 2:
						System.out.println("Enter the new mail");
						c.setMail(sc.next());
						if(cdao.updateCustomet(c))
						{
							System.out.println("updated sucessfully");
						}
						else
						{
							System.out.println("falied to update");
						}
						break;
					case 3:
						System.out.println("Enter the new phone");
						c.setPhone(sc.nextLong());
						if(cdao.updateCustomet(c))
						{
							System.out.println("updated sucessfully");
						}
						else
						{
							System.out.println("falied to update");
						}
						break;
					case 4:
						System.out.println("Enter the new age");
						c.setAge(sc.nextInt());
						if(cdao.updateCustomet(c))
						{
							System.out.println("updated sucessfully");
						}
						else
						{
							System.out.println("falied to update");
						}
						break;
					case 5:
						System.out.println("Enter the new password");
						c.setPassword(sc.next());
						if(cdao.updateCustomet(c))
						{
							System.out.println("updated sucessfully");
						}
						else
						{
							System.out.println("falied to update");
						}
						break;
					case 6:
						System.out.println("Thank you for updating your details back to options");
						break;
					default:
						System.out.println("!invalid choice");
						break;
					}
				}while(sw!=6);
				break;
			case 5:
				System.out.println("Exit");
				break;
			default:System.out.println("");
			}
		}while(ch!=5);
	}

}
