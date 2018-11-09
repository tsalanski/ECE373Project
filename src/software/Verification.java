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
		boolean checkName = false;
		boolean checkAddress = false;
		boolean checkPhone = false;
		boolean checkCardNo = false;
		boolean flag = false;
		for(int i = 0; i < this.ccList.size(); i++){
			/*if(this.ccList.get(i).getFullname().compareTo(cc1.getFullname()) == 0){
					checkName = true;
					//System.out.println("checkName is true");
					if(this.ccList.get(i).getAddress().compareTo(cc1.getAddress()) == 0){
						//System.out.println("checkAddress is true");
						checkAddress = true;
						if(this.ccList.get(i).getPhoneNo().compareTo(cc1.getPhoneNo()) == 0){
							//System.out.println("checkPhone is true");
							checkPhone = true;
							if(this.ccList.get(i).getCardNo().compareTo(cc1.getCardNo()) == 0){
								//System.out.println("checkCardNo is true");
								checkCardNo = true;
							}
						}
					}
			}
			if(checkName && checkAddress && checkPhone && checkCardNo){
				cc1 = this.ccList.get(i);
				flag = true;
			}
			else{
				flag = false;
			}*/
			flag = true;//TEMPORARY; remove when actual credit card verification is smoother
		}
		return flag;
	}
}
