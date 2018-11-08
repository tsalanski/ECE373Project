package people;
import hardware.*;

import java.util.ArrayList;

public class Account {
	// fields
	private String username;
	private String password;
	private String email;
	private ArrayList<CreditCard> creditCardList;
	private ArrayList<Concert> purchasedTicketList;
	private ArrayList<Concert> reservedTicketList;
	
	// constructor
	public Account() {
		this.username = "\0";
		this.password = "\0";
		this.email = "\0";
		this.creditCardList = new ArrayList<CreditCard>();
		this.purchasedTicketList = new ArrayList<Concert>();
		this.reservedTicketList = new ArrayList<Concert>();
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
	
	public ArrayList<CreditCard> getCreditCardList(){
		return this.creditCardList;
	}
	
	public ArrayList<Concert> getPurchasedTicketList(){
		return this.purchasedTicketList;
	}
	
	public ArrayList<Concert> getReservedTicketList(){
		return this.reservedTicketList;
	}
	
	// methods
	public void addCreditCard(CreditCard newCard) {
		this.creditCardList.add(newCard);
	}
	
	public void addPurchasedTicket(Concert newTicket) {
		this.purchasedTicketList.add(newTicket);
	}
	
	public void addReservedTicket(Concert newTicket) {
		this.reservedTicketList.add(newTicket);
	}
	
	// checks if user entered the correct email format
	public boolean checkEmailFormat(String str) {
		// user's email should contain ".com"
		if(str.contains("@") == true && str.contains(".com") == true) {
			this.setEmail(str);
			return true;
		}else {
			System.out.println("\nIncorrect format entered by user: please try again.\n");
			return false;
		}
	}
}
