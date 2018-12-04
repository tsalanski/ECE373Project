package people;

public class CreditCard {
	// fields
	private String fullname;
	private String address;
	private String cardNo;
	private String phoneNo;
	private int totDigits;
	private int firstDig;
	
	// constructors
	public CreditCard() {
		this.fullname = "\0";
		this.address = "\0";
		this.cardNo = "\0";
		this.phoneNo = "\0";
		this.totDigits = 0;
		this.firstDig = 0;
	}
	
	public int getCreditCardTotDigits() {
		return this.totDigits = this.cardNo.length();
	}
	
	public int getFirstDig() {
		this.firstDig = Character.getNumericValue(this.cardNo.charAt(0));
		return this.firstDig;
	}
	
	public CreditCard(String ccName, String ccAddress, String ccPhone, String ccNo) {
		this.fullname = ccName;
		this.address = ccAddress;
		this.cardNo = ccNo;
		this.phoneNo = ccPhone;
	}
	
	// setters
	public void setFullname(String str) {
		this.fullname = str;
	}
	
	public void setAddress(String str) {
		this.address = str;
	}
	
	public void setCardNo(String num) {
		this.cardNo = num;
	}
	
	public void setPhoneNo(String num) {
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
	
	public String getAddress(){
		return this.address;
	}
	
	public String getCardNo() {
		return this.cardNo;
	}
	
	public String getPhoneNo() {
		return this.phoneNo;
	}
	
	// methods
	
	boolean checkPhoneFormat(String num) {
		// user should enter 10 digits for a phone number
		
		if(num.length() > 10) {
			return false;
		}else {
			return true;
		}
	}
	
}