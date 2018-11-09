package people;

public class CreditCard {
	// fields
	private String fullname;
	private String address;
	private int cardNo;
	private int phoneNo;
	
	// constructors
	public CreditCard() {
		this.fullname = "\0";
		this.address = "\0";
		this.cardNo = 0;
		this.phoneNo = 0;
	}
	
	public CreditCard(String ccName, String ccAddress, int ccPhone, int ccNo) {
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
	
	public String getAddress(){
		return this.address;
	}
	
	public int getCardNo() {
		return this.cardNo;
	}
	
	public int getPhoneNo() {
		return this.phoneNo;
	}
	
	// methods
	
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
