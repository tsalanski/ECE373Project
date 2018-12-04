//JavaJams rocks!

package people;

import java.util.regex.Pattern;

public abstract class User {
	// fields
	private int accountNo;
	private int accountType; // (1: Listener, 2: Musician)
	private String name;
	private int birthday;
	private Account account;
	
	// constructor
	public User() {
		this.accountNo = 0;
		this.accountType = -1;
		this.name = "\0";
		this.birthday = 0;
		this.account = null;
	}
	
	// setters
	public void setAccountNo(int num) {
		this.accountNo = num;
	}
	
	public void setName(String str) {
		this.name = str;
	}
	
	public void setAccountType(int accType) {
		this.accountType = accType;
	}
	
	public void setBirthday(int num) {
		this.birthday = num;
	}
	
	public void setAccount(Account acc) {
		this.account = acc;
	}
	
	// getters
	public int getAccountNo() {
		return this.accountNo;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAccountType() {
		return this.accountType;
	}
	
	public int getBirthday() {
		return this.birthday;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	// methods
	public boolean checkBirthdayFormat(String str) {
		// user should enter in the following format: MMDDYYYY
		if(Pattern.matches("[0-9]+", str) && str.length() == 8) {
			this.setBirthday(Integer.parseInt(str));
			return true;
		}else {
			System.out.println("\nIncorrect format entered by user: please try again.\n");
			return false;
		}
	}
}
