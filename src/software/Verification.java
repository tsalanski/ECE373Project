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
			if(this.ccList.get(i).getFullname().compareTo(cc1.getFullname()) == 0){
					checkName = true;
					if(this.ccList.get(i).getAddress().compareTo(cc1.getAddress()) == 0){
						checkAddress = true;
						if(this.ccList.get(i).getPhoneNo() == cc1.getPhoneNo()){
							checkPhone = true;
							if(this.ccList.get(i).getCardNo() == cc1.getCardNo()){
								checkCardNo = true;
							}
						}
					}
			}
			if(checkName == true && checkAddress == true && checkPhone == true && checkCardNo == true){
				cc1 = this.ccList.get(i);
				flag = true;
			}
			else{
				flag = false;
			}
		}
		return flag;
	}
}
