package software;

import java.util.ArrayList;

import people.*;

public class Verification {
	// fields
	private ArrayList<Account> accountList;
	private ArrayList<CreditCard> ccList;
	
	// constructor
	public Verification() {
		this.accountList = new ArrayList<Account>();
		this.ccList = new ArrayList<CreditCard>();
	}
	
	// setters
	
	// getters
	public ArrayList<Account> getAccountList() {
		return this.accountList;
	}
	
	public ArrayList<CreditCard> getCreditCardList() {
		return this.ccList;
	}
	
	// methods
	public boolean verifyUser(String username, String password) {
		boolean checkUser = false;
		for(int i = 0; i < this.accountList.size(); i++) {
			if(this.accountList.get(i).getUsername() == username
					&& this.accountList.get(i).getPassword() == password) {
				checkUser = true;
			}
			else{
				checkUser = false;
				break;
			}
		}
		return checkUser;
	}
	
	public boolean verifyCard(CreditCard cc1) {
		boolean checkName = false;
		boolean checkAddress = false;
		boolean checkPhone = false;
		boolean checkCardNo = false;
		for(int i = 0; i < this.ccList.size(); i++){
			if(this.ccList.get(i).getFullname() == cc1.getFullname()){
					checkName = true;
					if(this.ccList.get(i).getAddress() == cc1.getAddress()){
						checkAddress = true;
						if(this.ccList.get(i).getPhoneNo() == cc1.getPhoneNo()){
							checkPhone = true;
							if(this.ccList.get(i).getCardNo() == cc1.getCardNo()){
								checkCardNo = true;
							}
						}
					}
			}
		}
		if(checkName == true && checkAddress == true && checkPhone == true && checkCardNo == true){
			return true;
		}
		else{
			return false;
		}
	}
}
