package software;

import java.util.ArrayList;

public class Category {

	private ArrayList<String> genres;
	private ArrayList<String> artists;
	private ArrayList<String> cities;
	
	public Category() {
		this.genres = new ArrayList<String>();
		this.artists = new ArrayList<String>();
		this.cities = new ArrayList<String>();
	}
	
	public ArrayList<String> getGenres() {
		return this.genres;
	}
	
	public void setGenres(String g) {
		this.genres.add(g);
	}
	
	public ArrayList<String> getArtists() {
		return this.artists;
	}
	
	public void setArtists(String a) {
		this.artists.add(a);
	}
	
	public ArrayList<String> getCities() {
		return this.cities;
	}
	
	public void setCities(String c) {
		this.cities.add(c);
	}
	
	
}