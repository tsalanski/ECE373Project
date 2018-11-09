package people;

import java.util.ArrayList;

import hardware.Concert;

public class Musician extends User {
	// fields
		private ArrayList<Concert> postedConcertsList;
		
		// constructor
		public Musician() {
			this.postedConcertsList = new ArrayList<Concert>();
		}
		
		// methods
		public void postConcert(Concert newConcert) {
			this.postedConcertsList.add(newConcert);
		}
}
