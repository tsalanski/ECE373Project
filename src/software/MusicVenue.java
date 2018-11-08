package software;
import hardware.Concert;
import java.util.ArrayList;

public class MusicVenue {
	private ArrayList<Concert> concerts;

	//Constructors
	public MusicVenue() {
		this.setConcerts(new ArrayList<Concert>());
	}
	
	public MusicVenue(ArrayList<Concert> concerts) {
		super();
		this.setConcerts(concerts);
	}

	//Getters and setters
	public ArrayList<Concert> getConcerts() {
		return concerts;
	}

	public void setConcerts(ArrayList<Concert> concerts) {
		this.concerts = concerts;
	}
	
	//Printer functions
	public void printConcertList() {
		System.out.print(this.concerts);
	}
	
	//Other Methods	
	public void sort() {
		
	}
	
	public void exit() {
		//exits the music venue screen and takes the user back to the main menu
	}
}
