package hardware;

import software.Category;

public abstract class Concert {
	private String location;
	private int date;
	private Category categories;
	
	//Constructors
	public Concert () {
		this.location = "No location";
		this.date = -1;
		this.categories = new Category();
	}
	
	public Concert(String location, int date, Category categories) {
		super();
		this.location = location;
		this.date = date;
		this.categories = categories;
	}	

	//Getters and setters
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
	public void printConcertInfo() {
		System.out.println(this.location);
		System.out.println(this.date);
	}
}
