package people;

import java.util.ArrayList;

import hardware.Concert;
import hardware.ConcertTicket;
import software.MusicVenue;

public class Musician extends User {
	// fields
		private ArrayList<Concert> postedConcertsList;
		
		// constructor
		public Musician() {
			this.postedConcertsList = new ArrayList<Concert>();
		}
		
		// methods
		public void postConcert(ConcertTicket newConcert) {
			MusicVenue m = new MusicVenue();
			this.postedConcertsList.add(newConcert);
			m.setConcerts(newConcert);
		}
}
