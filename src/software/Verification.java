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
	public void setNewAccount(Account acc){
		this.accountList.add(acc);
	}
	
	public void setNewCreditCard(CreditCard cc) {
		this.ccList.add(cc);
	}
	
	// getters
	public ArrayList<Account> getAccountList() {
		return this.accountList;
	}
	
	public ArrayList<CreditCard> getCreditCardList() {
		return this.ccList;
	}
	
	// methods
	public boolean verifyUser(User user1, String username, String password) {
		boolean checkUser = false;
		for(int i = 0; i < this.accountList.size(); i++) {
			if(this.accountList.get(i).getUsername().compareTo(username) == 0
					&& this.accountList.get(i).getPassword().compareTo(password) == 0) {
				checkUser = true;
				user1.setAccount(this.accountList.get(i));
			}
			else{
				checkUser = false;
				break;
			}
		}
		return checkUser;
	}
	
	public boolean verifyCard(CreditCard cc1) {
		boolean flag = true;
		int firstNum = cc1.getFirstDig();
		int creditCardNumSize = cc1.getCreditCardTotDigits();
		
		if((firstNum == 3 && creditCardNumSize != 15) || (firstNum == 5 && creditCardNumSize != 16) || (firstNum == 4 && creditCardNumSize != 13) || (firstNum == 4 && creditCardNumSize != 16) || (firstNum == 4 && creditCardNumSize != 19)) {//checking if the cards are American Express, MasterCard, and Visa Cards
			flag = false;
		}

		return flag;
	}
}
