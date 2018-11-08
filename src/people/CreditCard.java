package people;

import java.util.ArrayList;

public class CreditCard {
	// fields
	private String fullname;
	private ArrayList<String> addressList;
	private int cardNo;
	private int phoneNo;
	
	// constructor
	public CreditCard() {
		this.fullname = "\0";
		this.addressList = new ArrayList<String>();
		this.cardNo = 0;
		this.phoneNo = 0;
	}
	
	// setters
	public void setFullname(String str) {
		this.fullname = str;
	}
	
	public void setCardNo(int num) {
		this.cardNo = num;
	}
	
	public void setPhoneNo(int num) {
		if(checkPhoneFormat(num) == true) {
			this.phoneNo = num;
		}else {
			System.out.println("\nError: Phone no. should have 10 digits, please try again.\n");
		}
	}
	
	// getters
	public String getFullname() {
		return this.fullname;
	}
	
	public ArrayList<String> getAddressList(){
		return this.addressList;
	}
	
	public int getCardNo() {
		return this.cardNo;
	}
	
	public int getPhoneNo() {
		return this.phoneNo;
	}
	
	// methods
	public void addAddress(String newAddress) {
		this.addressList.add(newAddress);
	}
	
	boolean checkPhoneFormat(int num) {
		// user should enter 10 digits for a phone number
		int digits = (int) (Math.log10(num)+1);
		if(digits > 10) {
			return false;
		}else {
			return true;
		}
	}
	
}
