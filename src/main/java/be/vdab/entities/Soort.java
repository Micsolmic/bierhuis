package be.vdab.entities;

public class Soort {

	int id;
	String naam;
	
	public Soort(int id, String naam) {
		this.id = id;
		this.naam = naam;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
}
