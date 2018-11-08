package software;

import people.*;
import hardware.*;

import java.util.Scanner;
import java.util.Random;


public class Driver1 {
	public static void main(String[] args) 
	{
		int pageNo = -1;
		boolean exit = false;
		pageNo = 1;										// Program starts at Login page
		Scanner user_input = new Scanner(System.in);	// user input
		String option = "\0";							// User input for options
		Random rand = new Random();						// Generate random number
		
		// Program starts here:
		while(exit == false) 
		{
			switch (pageNo) {
			case 1:
				// Login Page:  existing user may entered their username & password
				//				new user can goto create a new account which takes them to the "Registration" page
				System.out.println("Login\n");
				System.out.println("Would you like to create a new account or proceed to login?\n");
				System.out.println("Please enter (new) or (login) to proceed:  ");
				option = user_input.next();
				
				if(option.compareTo("new") == 0) {
					pageNo = 2;	// Goto "Registration" page
				}
				else if(option.compareTo("login") == 0) {
					String username = "\0";
					System.out.print("Enter your user name: ");
					username = user_input.next();
					
					String password = "\0";
					System.out.print("Enter your password: ");
					password = user_input.next();
					
					pageNo = 3;	// Goto "Verfication" page
				}
				else {
					System.out.println("Error: Invalid entry, please try again.\n");
					pageNo = 1; // Return to "Login" page
				}
				
			case 2:
				// Registration page:  if new user wants to create a new account
				// After registration is complete, returns to "Login" page
				// User can also cancel at anytime and return to the "Login" page
				System.out.println("Registration\n");
				System.out.println("Would you like to register as Listener or Musician?");
				System.out.println("Please enter (L) or (M):  ");
				option = user_input.next();
				
				if(option.compareTo("L") == 0) {
					System.out.println("You are registering as a Listener\n");
					
					System.out.print("Please enter your fullname:  ");
					String fullname = "\0";
					fullname = user_input.next();
					
					System.out.println("Please enter your birthday:  ");
					String birthday = "\0";
					birthday = user_input.next();
					
					int accountNo = rand.nextInt(1000);	// Generate new Account No.
					
					Listener user0 = new Listener();
					user0.setName(fullname);
					user0.setBirthday(Integer.parseInt(birthday));
					user0.setAccountNo(accountNo);
					
					System.out.print("Please enter a username for your new account:  ");
					String username = "\0";
					username = user_input.next();
					
					System.out.print("Please enter a password for your new account:  ");
					String password = "\0";
					password = user_input.next();
					
					System.out.print("Please enter a email for your new account:  ");
					String email = "\0";
					email = user_input.next();
					
					Account account0 = new Account();
					account0.setUsername(username);
					account0.setPassword(password);
					account0.setEmail(email);
					user0.setAccount(account0);
										
				}
				else if(option.compareTo("M") == 0) {
					System.out.println("You are registering as a Musician\n");
					System.out.print("Please enter your fullname:  ");
					String fullname = "\0";
					fullname = user_input.next();
					
					System.out.println("Please enter your birthday:  ");
					String birthday = "\0";
					birthday = user_input.next();
					
					int accountNo = rand.nextInt(1000);	// Generate new Account No.
					
					Musician user1 = new Musician();
					user1.setName(fullname);
					user1.setBirthday(Integer.parseInt(birthday));
					user1.setAccountNo(accountNo);
					
					System.out.print("Please enter a username for your new account:  ");
					String username = "\0";
					username = user_input.next();
					
					System.out.print("Please enter a password for your new account:  ");
					String password = "\0";
					password = user_input.next();
					
					System.out.print("Please enter a email for your new account:  ");
					String email = "\0";
					email = user_input.next();
					
					Account account1 = new Account();
					account1.setUsername(username);
					account1.setPassword(password);
					account1.setEmail(email);
					user1.setAccount(account1);
				}
				pageNo = 1;	// Return to "Login" page
			case 3:
				// Verification page: checks if information entered by user is valid/invalid
				// Valid user is taken to the "Music Venue" (main page)
				// Invalid user is taken to the "Access Denied" Page and returns to the Login page
				System.out.println("Verification\n");
				break;
			case 4:
				// Music Venue (main page):  User can start looking for Concerts by going to browse which takes user to "Display Concerts" page
				// User may choose to exit the application at anytime which returns them to "Login" page.
				System.out.println("Music Venue\n");
				break;
			case 5:
				// Display Concerts page:  User can sort by categories: genre, artist, city
				// User may choose Concert Tickets, this takes them to "Display Concert Ticket" page displaying the ticket information
				// User may choose to return to previous page which takes them back to "Music Venue" page
				System.out.println("Concerts\n");
				break;
			case 6:
				// Display Concert Tickets page:  User have the option to reserve/purchase ticket
				// Reserve & purchase requires to verify the number of available seats before proceeding "Reservation Complete" page
				System.out.println("Concert Ticket\n");
				break;
			case 7:
				// Reservation Complete page: Displays successful reservation notification
				// Tickets reserved should be added to the user's reserved ticket list and update the available seats
				// User has the option to share on social media or return to main page
				System.out.println("Reservation Complete\n");
				break;
			case 8:
				// Enter Credit Card page:  User has chosen the purchase option
				// After user has entered credit card information, they will be taken to the "Verification" page
				// User may choose to cancel at any time and returns to "Display Concert Tickets" page
				System.out.println("Please enter your credit card information\n");
				break;
			case 9:
				// Verification page:  checks if credit card information is valid/invalid
				// Valid credit card takes the user to "Purchase Complete" page
				// Invalid credit card display error message and returns the user to "Enter Credit Card" page
				System.out.println("Verification\n");
				break;
			case 10:
				// Purchase Complete page: Displays successful purchased notification
				// Tickets purchased should be added to user's purchased ticket list and update the available seats
				// User has the option to share on social media or return to main page
				System.out.println("Purchase Complete\n");
				break;
			default:
					break;
			}
			
		}
	}
}
