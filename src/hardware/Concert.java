package hardware;

import software.Category;

public abstract class Concert {
	private String concertName;
	private String location;
	private int availableSeat;
	private String date;
	private String artist;
	private String genre;
	private String city;
	private Category categories;
	
	//Constructors
	public Concert () {
		this.concertName = "unknown";
		this.location = "No location";
		this.availableSeat = -1;
		this.date = null;
		this.artist = "unknown";
		this.genre = "unknown";
		this.city = "unknown";
		this.categories = new Category();
	}
	
	public Concert(String location, int seat, int date, Category categories) {
		super();
		this.location = location;
		this.setDate(date);
		this.availableSeat = seat;
		this.categories = categories;
	}	

	//Getters and setters
	public void setCity(String str) {
		this.city = str;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setArtist(String str) {
		this.artist = str;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public void setGenre(String str) {
		this.genre = str;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
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

	public String getDate() {
		return date;
	}

	public void setDate(int fourDigit) {
		String str = "";
		String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		int m = fourDigit/100;
		int d = fourDigit - 100*m;
		str += month[m] + " " + d + "," + "2018";
		this.date = str;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
	
	//Print functions
	public void printConcertInfo() {
		System.out.println("Concert Name:  " + this.concertName);
		System.out.println("Location:  " + this.location);
		System.out.println("Date:  " + this.date);
		System.out.println("Available seats:  " + this.getAvailableSeat());
		
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
