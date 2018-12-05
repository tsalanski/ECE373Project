package people;
import hardware.*;

import java.util.ArrayList;

public class Account {
	// fields
	private String username;
	private String password;
	private String email;
	private int accountType; // (1: Listener, 2: Musician)
	private ArrayList<CreditCard> creditCardList;
	private ArrayList<ConcertTicket> purchasedTicketList;
	private ArrayList<ConcertTicket> reservedTicketList;
	
	// constructor
	public Account() {
		this.username = "\0";
		this.password = "\0";
		this.email = "\0";
		this.accountType = -1;
		this.creditCardList = new ArrayList<CreditCard>();
		this.purchasedTicketList = new ArrayList<ConcertTicket>();
		this.reservedTicketList = new ArrayList<ConcertTicket>();
	}
	
	// setters
	public void setUsername(String str) {
		this.username = str;
	}
	
	public void setPassword(String str) {
		this.password = str;
	}
	
	public void setEmail(String str) {
		this.email = str;
	}
	
	public void setAccountType(int accType) {
		this.accountType = accType;
	}
	
	// getters
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getAccountType() {
		return this.accountType;
	}
	
	public ArrayList<CreditCard> getCreditCardList(){
		return this.creditCardList;
	}
	
	public ArrayList<ConcertTicket> getPurchasedTicketList(){
		return this.purchasedTicketList;
	}
	
	public ArrayList<ConcertTicket> getReservedTicketList(){
		return this.reservedTicketList;
	}
	
	// methods
	public void addCreditCard(CreditCard newCard) {
		this.creditCardList.add(newCard);
	}
	
	public void addPurchasedTicket(ConcertTicket newTicket) {
		this.purchasedTicketList.add(newTicket);
	}
	
	public void addReservedTicket(ConcertTicket newTicket) {
		this.reservedTicketList.add(newTicket);
	}
	
	// checks if user entered the correct email format
	public boolean checkEmailFormat(String str) {
		// user's email should contain ".com", ".edu", "@"
		if(str.contains("@") == true && (str.contains(".com") == true || str.contains(".edu") == true)) {
			this.setEmail(str);
			return true;
		}else {
			System.out.println("\nIncorrect format entered by user: please try again.\n");
			return false;
		}
	}
	
	// display account info
	public void displayAccountInfo(User u1) {
		System.out.println("Account No.:  " + u1.getAccountNo());
		String str = "";
		if(u1.getAccountType() == 1) {
			str += "Listener";
		}else if(u1.getAccountType() == 2) {
				str += "Musician";
		}
		System.out.println("Account Type:  " + str);
		System.out.println("Name:  " + u1.getName());
		System.out.println("Email:  " + this.email);
		
		// Prints saved credit card list
		System.out.println("Your saved Credit Cards:\n");
		if(this.creditCardList.isEmpty()) {
			System.out.println("You have not saved any Credit Cards in your account.\n");
		}else {
			for(int i = 0; i < this.creditCardList.size(); i++) {
				System.out.println("Credit Card No.:  " + this.creditCardList.get(i).getCardNo());
			}
		}
		
		// Prints reserved tickets
		System.out.println("Your Reserved Tickets:\n");
		if(this.reservedTicketList.isEmpty()) {
			System.out.println("You have not reserved any tickets.\n");
		}else {
			for(int i = 0; i < this.reservedTicketList.size(); i++) {
				reservedTicketList.get(i).printTicket();
			}
		}
		
		// Prints purchased tickets
		System.out.println("Your Purchased Tickets:\n");
		if(this.purchasedTicketList.isEmpty()) {
			System.out.println("You have not purchased any tickets.\n");
		}else {
			for(int i = 0; i < this.purchasedTicketList.size(); i++) {
				purchasedTicketList.get(i).printTicket();
			}
		}
		
	}
}
