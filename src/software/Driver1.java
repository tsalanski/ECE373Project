package software;

public class Driver1 {
	public static void main(String[] args) 
	{
		// Program starts here:
		// Login Page:  existing user may entered their username & password
		//				new user can goto create a new account which takes them to the registration page
		
		
		// Registration page:  if new user wants to create a new account
		// After registration is complete, returns to Login page
		// User can also cancel at anytime and return to the Login page
		
		
		// Verification page: checks if information entered by user is valid/invalid
		// Valid user is taken to the Music Venue (main page)
		// Invalid user is taken to the Access Denied Page and returns to the Login page
		
		
		// Music Venue (main page):  User can start looking for Concerts by going to browse which goes to a new page to display Concerts
		// User may choose to exit the application at anytime which returns them to Login page.
		
		
		// Display Concerts page:  User can sort by categories: genre, artist, city
		// User may choose Concert Tickets, this takes them to a new page displaying the ticket information
		// User may choose to return to previous page which takes them back to Music Venue
		
		
		// Display Concert Tickets page:  User have the option to reserve/purchase ticket
		// Reserve & purchase requires to verify the number of available seats before proceeding to the next page
		
		
		// Reservation Complete page: Displays successful reservation notification
		// Tickets reserved should be added to the user's reserved ticket list and update the available seats
		// User has the option to share on social media or return to main page
		
		
		// Enter Credit Card page:  User has chosen the purchase option
		// After user has entered credit card information, they will be taken to the verification page
		// User may choose to cancel at any time and returns to Display Concert Tickets page
		
		
		// Verification page:  checks if credit card information is valid/invalid
		// Valid credit card takes the user to Purchase Complete page
		// Invalid credit card returns the user to Enter Credit Card page
		
		
		// Purchase Complete page: Displays successful purchased notification
		// Tickets purchased should be added to user's purchased ticket list and update the available seats
		// User has the option to share on social media or return to main page
	}
}
