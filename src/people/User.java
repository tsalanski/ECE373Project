package people;

public abstract class User {
	// fields
	private int accountNo;
	private String name;
	private int birthday;
	private Account account;
	
	// constructor
	public User() {
		this.accountNo = 0;
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
	
	public void setBirthday(int num) {
		if(checkBirthdayFormat(num) == true) {
			this.birthday = num;
		}else {
			System.out.println("\nIncorrect format entered by user: please try again.\n");
		}
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
	
	public int getBirthday() {
		return this.birthday;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	// methods
	boolean checkBirthdayFormat(int num) {
		// user should enter in the following format: MMDDYYYY
		int digits = (int) (Math.log10(num)+1);
		if(digits > 8) {
			return false;
		}else {
			return true;
		}
	}
}
