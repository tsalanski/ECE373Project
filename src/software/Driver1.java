package software;

import people.*;
import hardware.*;

import java.util.Scanner;
import java.util.Random;
import java.io.InputStreamReader;


public class Driver1 {
	public static void main(String[] args) 
	{
		int pageNo = -1;
		int verifyType = -1;
		boolean exit = false;
		pageNo = 1;										// Program starts at Login page
		Scanner user_input = new Scanner(System.in);	// user input
		String option = "\0";							// User input for options
		
		String username = "\0";							// User Login information entries:
		String password = "\0";
		
		String ccName = "\0";							// Credit Card information entries:
		String ccAddress = "\0";
		int ccPhone = 0;
		int ccNo = 0;
		
		Random rand = new Random();						// Generate random number
		
		Listener user0 = new Listener();				// Create new Listener
		Musician user1 = new Musician();				// Create new Musician
		Account account1 = new Account();				// create new Account
		Verification verify = new Verification();
		MusicVenue venue = new MusicVenue();			// create MusicVenue object
		ConcertTicket ticket = new ConcertTicket();		// create ConcertTicket object
		Concert newReserved = new ConcertTicket();		// create Concert object for reserved ticket
		Concert newPurchased = new ConcertTicket();		// create Concert object for purchased ticket

		int index = -1;									// indexing for information retrieval
		
		// Initialize Concerts for testing purposes:
		account1.setUsername("admin");
		account1.setPassword("12345");
		account1.setEmail("admin@emai.com");
		User userL = new Listener();
		userL.setAccount(account1);
		verify.setNewAccount(account1);
		
		ConcertTicket ticket1 = new ConcertTicket();
		ticket1.setPrice(175.00);
		ticket1.setSeat(52);
		ticket1.setConcertName("Concert No. 1");
		ticket1.setAvailableSeat(100);
		ticket1.setDate(8);
		ticket1.setLocation("Tucson");
		venue.setConcerts(ticket1);
		
		ConcertTicket ticket2 = new ConcertTicket();
		ticket2.setPrice(105.00);
		ticket2.setSeat(11);
		ticket2.setConcertName("Concert No. 2");
		ticket2.setAvailableSeat(50);
		ticket2.setDate(15);
		ticket2.setLocation("Phoenix");
		venue.setConcerts(ticket2);
		
		ConcertTicket ticket2 = new ConcertTicket();
		ticket2.setPrice(105.00);
		ticket2.setSeat(11);
		ticket2.setConcertName("Concert No. 2");
		ticket2.setAvailableSeat(50);
		ticket2.setDate(15);
		ticket2.setLocation("Phoenix");
		venue.setConcerts(ticket2);
		
		// Program starts here:
		while(exit == false) 
		{
			switch (pageNo) {
			
////////// LOGIN ////////// LOGIN  ////////// LOGIN ////////// LOGIN ////////// LOGIN ////////// 			
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
					System.out.print("Enter your user name: ");
					username = user_input.next();
					
					System.out.print("Enter your password: ");
					password = user_input.next();
					
					pageNo = 3;			// Goto "Verfication" page
					verifyType = 1;		// Type 1: User verification
					break;
				}
				else {
					System.out.println("Error: Invalid entry, please try again.\n");
					pageNo = 1; // Return to "Login" page
					break;
				}
				
////////// REGISTRATION ////////// REGISTRATION  ////////// REGISTRATION ////////// REGISTRATION //////////		
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
					
					System.out.print("Please enter your name (no spaces):  ");
					String fullname = "\0";
					fullname = user_input.next();
					user0.setName(fullname);
					
					// needs to check if user entered the correct birthday format
					boolean error = false;
					while(error == false) {
						System.out.println("Please enter your birthday as an 8-digit number (MMDDYYYY):  ");
						String birthday = "\0";
						birthday = user_input.next();
						error = user0.checkBirthdayFormat(birthday);
					}
					
					int accountNo = rand.nextInt(1000);	// Generate new Account No.
					user0.setAccountNo(accountNo);
					
					System.out.print("Please enter a username for your new account:  ");
					username = user_input.next();
					
					System.out.print("Please enter a password for your new account:  ");
					password = user_input.next();
					
					account1.setUsername(username);
					account1.setPassword(password);
					
					error = false;
					while(error == false) {
						System.out.print("Please enter a email for your new account:  ");
						String email = "\0";
						email = user_input.next();
						error = account1.checkEmailFormat(email);
					}
					
					// sets new account to user
					user0.setAccount(account1);
					verify.setNewAccount(account1);	
				}
				else if(option.compareTo("M") == 0) {
					System.out.println("You are registering as a Musician\n");
					System.out.print("Please enter your name (no spaces):  ");
					String fullname = "\0";
					fullname = user_input.next();
					user1.setName(fullname);
					
					// needs to check if user entered the correct birtyday format
					boolean error = false;
					while(error == false) {
						System.out.println("Please enter your birthday as an 8-digit number (MMDDYYYY):  ");
						String birthday = "\0";
						birthday = user_input.next();
						error = user1.checkBirthdayFormat(birthday);
					}
					
					
					int accountNo = rand.nextInt(1000);	// Generate new Account No.
					user1.setAccountNo(accountNo);
					
					System.out.print("Please enter a username for your new account:  ");
					username = user_input.next();
					
					System.out.print("Please enter a password for your new account:  ");
					password = user_input.next();
					
					account1.setUsername(username);
					account1.setPassword(password);
					
					error = false;
					while(error == false) {
						System.out.print("Please enter a email for your new account:  ");
						String email = "\0";
						email = user_input.next();
						error = account1.checkEmailFormat(email);
					}
					
					// sets new account to user
					user1.setAccount(account1);
					verify.setNewAccount(account1);
				}
				pageNo = 1;	// Return to "Login" page
				break;
				
////////// VERIFICATION ////////// VERIFICATION  ////////// VERIFICATION ////////// VERIFICATION ////////// VERIFICATION 			
			case 3:
				// Verification page: checks if information entered by user is valid/invalid
				// Valid user is taken to the "Music Venue" (main page)
				// Invalid user is taken to the "Access Denied" Page and returns to the Login page
				System.out.println("Verification\n");
				System.out.println("Verifying User...\n");
				if(verifyType == 1) {	// 1: user verification
					if(verify.verifyUser(user0, username, password) == true) {
						pageNo = 4;		// Goto "Music Venue" page
						break;
					}else {
						System.out.println("Invalid user, returning to Login page\n");
						pageNo = 1;		// Return to "Login" page
						break;
					}
				}
				else if(verifyType == 2) {	// 2: credit card verification
					System.out.println("Verifying Credit Card Information...\n");
					CreditCard cc1 = new CreditCard(ccName, ccAddress, ccPhone, ccNo);
					if(verify.verifyCard(cc1) == true) {
						newPurchased = venue.getConcert().get(index);
						pageNo = 10;	// Goto "Purchase Complete" page
						break;
					}else {
						System.out.println("Invalid credit card, returning to previous page\n");
						pageNo = 8; 	// Return to "Enter Credit Card" page
						break;
					}
				}
				
////////// MUSIC VENUE ////////// MUSIC VENUE  ////////// MUSIC VENUE ////////// MUSIC VENUE //////////		
			case 4:
				// Music Venue (main page):  User can start looking for Concerts by going to browse which takes user to "Display Concerts" page
				// User may choose to exit the application at anytime which returns them to "Login" page.
				System.out.println("Music Venue\n");
				System.out.println("Enter (concert) to browse available concerts or (account) to get account information:  ");
				option = user_input.next();
				if(option.compareTo("concert") == 0) {
					pageNo = 5; // Goto "Concerts" page
				}else if(option.compareTo("account") == 0) {
					if(user0 == null) {
						user1.getAccount().displayAccountInfo(user1);
					}else {
						user0.getAccount().displayAccountInfo(user0);
					}
					pageNo = 4;
					break;
				}else {
					System.out.println("Would you like to exit Music Venue? Please enter: \"Yes\" or \"No\"\n");
					option = user_input.next();
					if(option.compareTo("Yes") == 0) {
						pageNo = 1;
						break;
					}else {
						pageNo = 4;
						break;
					}
				}
				
				//venue.exit();
////////// CONCERTS ////////// CONCERTS  ////////// CONCERTS ////////// CONCERTS //////////	CONCERTS //////////	
			case 5:
				// Display Concerts page:  User can sort by categories: genre, artist, city
				// User may choose Concert Tickets, this takes them to "Display Concert Ticket" page displaying the ticket information
				// User may choose to return to previous page which takes them back to "Music Venue" page
				System.out.println("\nConcerts\n");

				venue.printConcertList();
				System.out.println("Please enter a number to select Concert: ");
				option = user_input.next();
				index = Integer.parseInt(option);
				
				System.out.println("\nWould you like to Reserve or Purchase ticket?\n");
				System.out.println("Please enter the following options (R) or (P): ");
				option = user_input.next();
				
				if(option.compareTo("R") == 0) {
					newReserved = venue.getConcert().get(index);
					if(newReserved.checkAvailableSeats() == false) {
						System.out.println("No seats available, please try again at a later time.\n");
					}else {
						user0.getAccount().addReservedTicket(newReserved);
						pageNo = 7;	// Goto "Reserved Complete" page
						break;
					}
				}else if(option.compareTo("P") == 0) {
					newPurchased = venue.getConcert().get(index);
					if(newPurchased.checkAvailableSeats() == false) {
						System.out.println("No seats available, please try again at a later time.\n");
					}else {
						pageNo = 8; // Goto "Enter Credit Card" page
						break;
					}
				}
				//venue1.sort();
			
  ////////// RESERVED ////////// RESERVED  ////////// RESERVED ////////// RESERVED //////////		
			case 7:
				// Reservation Complete page: Displays successful reservation notification
				// Update the available seats
				// User has the option to share on social media or return to main page
				System.out.println("Reservation Complete\n");
				
				// update available seating
				newReserved.setAvailableSeat(-1);
				
				pageNo = 4;		// Goes back to "Music Venue" page
				break;

				
////////// CREDIT CARD ////////// CREDIT CARD  ////////// CREDIT CARD ////////// CREDIT CARD //////////		
			case 8:
				// Enter Credit Card page:  User has chosen the purchase option
				// After user has entered credit card information, they will be taken to the "Verification" page
				// User may choose to cancel at any time and returns to "Display Concert Tickets" page
				System.out.println("Please enter your credit card information\n");
				
				
				System.out.print("Please enter your Credit Card Name:  ");
				ccName = user_input.next();
				System.out.print("Please enter your Credit Card Address:  ");
				ccAddress = user_input.next();
				System.out.print("Please enter your Credit Card Phone number:  ");
				String buffer;
				buffer = user_input.next();
				ccPhone = Integer.parseInt(buffer);
				System.out.print("Please enter your Credit Card number:  ");
				buffer = user_input.next();
				ccNo = Integer.parseInt(buffer);
				
				verifyType = 2;	// Type 2: Credit Card Verification
				pageNo = 3;	// Goto "Verification" page
				break;
				
////////// PURCHASED ////////// PURCHASED  ////////// PURCHASED ////////// PURCHASED //////////		
			case 9:
				// Purchase Complete page: Displays successful purchased notification
				// Update the available seats
				// User has the option to share on social media or return to main page
				
				//drop down menu when we build the GUI to choose between Facebook and Twitter?
				System.out.println("Purchase Complete\n");
				
				// update available seating
				newPurchased.setAvailableSeat(-1);
				
				pageNo = 4;		// Goes back to "Music Venue" page
				SocialMedia media = new SocialMedia();
				//ConcertTicket purTicket = new ConcertTicket(20.0, 1);
				System.out.println("Share to Facebook/Twitter?");
				Scanner scanner = new Scanner( System.in );
				String input = scanner.nextLine();
				media.setPlatform(input);
				//media.share(purTicket);
				break;
         
 /////////////////////////////////////////////////////////////////////////////////////////////////////				
			default:
					break;
			}
			
		}
	}
}
