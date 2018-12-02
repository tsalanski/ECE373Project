package hardware;

import software.Category;

public abstract class Concert {
	private String concertName;
	private String location;
	private int availableSeat;
	private int date;
	private Category categories;
	
	//Constructors
	public Concert () {
		this.concertName = "\0";
		this.location = "No location";
		this.availableSeat = -1;
		this.date = -1;
		this.categories = new Category();
	}
	
	public Concert(String location, int seat, int date, Category categories) {
		super();
		this.location = location;
		this.date = date;
		this.availableSeat = seat;
		this.categories = categories;
	}	

	//Getters and setters
	public int getAvailableSeat() {
		return this.availableSeat;
	}
	
	public void setAvailableSeat(int num) {
		this.availableSeat = num;
	}
	
	public String getConcertName() {
		return this.concertName;
	}
	
	public void setConcertName(String str) {
		this.concertName = str;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
	
	//Print functions
	public void printConcertInfo(int fourDigit) {
		System.out.println("Concert Name:\t" + this.concertName);
		System.out.println("Location:\t" + this.location);
		printDate(fourDigit);
	}
	
	// format MMDD
	public void printDate(int fourDigit) {
		String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		int m = fourDigit/100;
		int d = fourDigit - 100*m;
		System.out.println(month[m] + " " + d + "," + "2018");
	}
	
	public boolean checkAvailableSeats() {
		if(this.availableSeat != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void removeAvailableSeats() {
		this.availableSeat = this.availableSeat - 1;
	}
}
