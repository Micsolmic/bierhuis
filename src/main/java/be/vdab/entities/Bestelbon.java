package be.vdab.entities;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import be.vdab.valueobjects.Adres;


public class Bestelbon {

	int id;
	@NotNull
	String naam;
	@Valid
	Adres adres;
	
	public Bestelbon(int id, String naam, Adres adres) {
		this.id = id;
		this.naam = naam;
		this.adres = adres;
	}
	
	public Bestelbon() {
		this.id = 0;
		this.naam = "";
		this.adres = new Adres();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
}
