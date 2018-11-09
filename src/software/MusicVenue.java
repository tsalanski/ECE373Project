package software;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*; 

import hardware.*;

public class MusicVenue {

	private ArrayList<ConcertTicket> concerts;
	private String address;
	private String name;
	private int capacity;
	
	public MusicVenue() {
		this.concerts = new ArrayList<ConcertTicket>();
		this.address = "unknown";
		this.name = "unknown";
		this.capacity = 0;
	}
	
	public ArrayList<ConcertTicket> getConcert() {
		return this.concerts;
	}
	
	public void setConcerts(ConcertTicket c) {
		this.concerts.add(c);
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String addy) {
		this.address = addy;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//Other Methods	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int cap) {
		this.capacity = cap;
	}
	
	public void sort() {//i'm sorting alphabetically for now by name
		 
	}
	
	public void printConcertList() {
		int count = 0;
		for (int i = 0; i < this.concerts.size(); i++) {
			count++;
			System.out.println(count + ") " + this.concerts.get(i).getConcertName()
							   + "\n   Location:\t" + this.concerts.get(i).getLocation()
							   + "\n   Date:\t\t" + this.concerts.get(i).getDate()
							   + "\n   Price:\t\t" + "$" + this.concerts.get(i).getPrice() 
							   + "\n   Remainging seats:\t" + this.concerts.get(i).getAvailableSeat() +"\n\n");
		}
	}
	
	public void exit() {
		//exits the music venue screen and takes the user back to the main menu
	}
}
