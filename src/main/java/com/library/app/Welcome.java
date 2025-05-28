package com.library.app;

import java.util.Scanner;

public class Welcome {
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int ch=0;
		do {
			System.out.println("1. Signup");
			System.out.println("2. login");
			System.out.println("3. Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				Signup.signup();
				break;
			case 2:
				Login.login();
				break;
			case 3:
				System.out.println("Thank You for Visiting LibraryAPP");
				break;
			default:
				System.out.println("!invalid choice");
				break;
			}
		}while(ch!=3);
	}

}
