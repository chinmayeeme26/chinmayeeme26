package com.library.app;

import java.util.Scanner;

import com.library.dto.Book;
import com.library.dao.*;
public class Update {

	public static void update() {
		// TODO Auto-generated method stub
		Book b=new Book();
		BookDAO bdao=new BookDAOImp();
		CustomerDAO cdao=new CustomerDAOImp();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the bid of the book to be updated");
		b=bdao.getBook(sc.nextInt());
		int ch=0;
		do 
		{
			System.out.println("Update book data");
			System.out.println("1. Update book title");
			System.out.println("2. Update book author");
			System.out.println("3. Update book Language");
			System.out.println("4. Update book Year");
			System.out.println("5. Update book price");
			System.out.println("6. Update book status");
			System.out.println("7. back to admin page");
			System.out.println("8. back to login page");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("enter the title of the book");
				b.setTitle(sc.next());
				boolean r=bdao.updateBook(b);
				if(r)
					System.out.println("title updated successfully");
				else
					System.out.println("failed to update try again");
				break;
			case 2:
				System.out.println("enter the author of the book");
				b.setAuthor(sc.next());
				r=bdao.updateBook(b);
				if(r)
					System.out.println("aurhor updated successfully");
				else
					System.out.println("failed to update try again");
				break;
			case 3:
				System.out.println("enter the Language of the book");
				b.setLanguage(sc.next());
				r=bdao.updateBook(b);
				if(r)
					System.out.println("language updated successfully");
				else
					System.out.println("failed to update try again");
				break;
			case 4:
				System.out.println("enter the Year of the book");
				b.setYear(sc.next());
				r=bdao.updateBook(b);
				if(r)
					System.out.println("year updated successfully");
				else
					System.out.println("failed to update try again");
				break;
			case 5:
				System.out.println("enter the price of the book");
				b.setPrice(sc.nextDouble());
				r=bdao.updateBook(b);
				if(r)
					System.out.println("price updated successfully");
				else
					System.out.println("failed to update try again");
				break;
			case 6:
				System.out.println("enter the status of the book");
				b.setStatus(sc.next());
				r=bdao.updateBook(b);
				if(r)
					System.out.println("status updated successfully");
				else
					System.out.println("failed to update try again");
				break;
			case 7:
				System.out.println("Back to admin page");
				Admin.admin(cdao.getCustomet(1));
				break;
			case 8:
				System.out.println("Back to login page");
				break;
			default:
				System.out.println("!invalid choice");
				break;
			}
		}while(ch!=8);
	}

}
