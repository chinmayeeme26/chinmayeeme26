package com.library.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.library.dto.Book;
import com.library.dto.Customer;
import com.library.dao.*;
public class Admin {

	public static void admin(Customer c) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CustomerDAO cdao=new CustomerDAOImp();
		BookDAO bdao=new BookDAOImp();
		int ch=0;
		do {
			System.out.println("1. Insert Book data");
			System.out.println("2. Get customers data ");
			System.out.println("3. Get Books data");
			System.out.println("4. delete customer data");
			System.out.println("5. delete Book data");
			System.out.println("6. update Book data");
			System.out.println("7. Access your account");
			System.out.println("8. Back to main menu");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				Book b=new Book();
				System.out.println("enter Book Title");
				b.setTitle(sc.next());				//how to add nextLine or any other scanner inputs after another nextLine 
				System.out.println("Enter the book Author");
				b.setAuthor(sc.next());
				System.out.println("Enter Language");
				b.setLanguage(sc.next());
				System.out.println("Enter the Year of publication");
				b.setYear(sc.next());
				System.out.println("Enter the price of the book");
				b.setPrice(sc.nextInt());
				bdao.insertBook(b);
				break;
			case 2:
				System.out.println("<====Customers Data=====>");
				List<Customer> c1=cdao.getCustomer();
				Iterator<Customer> it=c1.iterator();
				while(it.hasNext())
				{
					Customer c2=it.next();
					System.out.println(c2);
				}
				break;
			case 3:
				System.out.println("<======Books Data=======>");
				List<Book> bl=bdao.getBook(c);
				Iterator<Book> ib=bl.iterator();
				while(ib.hasNext())
				{
					Book b1=ib.next();
					System.out.println(b1);
				}
				break;
			case 4: 
				System.out.println("Enter the cid of the customer to be deleted");
				Customer cd=cdao.getCustomet(sc.nextInt());
				if(cd.getCid()!=c.getCid()&&cd.getDue()==0)
				{
					cdao.deleteCustomet(cd);
				}
				else
					System.out.println("Customer have dues to fill");
				break;//done
			case 5:
				System.out.println("enter the bid of the book to be deleted");
				Book bd=bdao.getBook(sc.nextInt());
				if(bd.getStatus().equals("Avilable"))
				{
					bdao.deleteBook(bd);
				}
				else
					System.out.println("Book is not avilable to delete");
				break;
			case 6:
				Update.update();
				break;
			case 7:
				App.options(c);
				break;
			case 8:
				System.out.println("Thankyou for visiting the application");
				break;
			default:
				System.out.println("!Invalid choice");
				break;
			}
		}while(ch!=6);
	}

}
