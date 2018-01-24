package be.vdab.entities;


import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



public class Bier{
	
	
	int id;
	String naam;
	int brouwerid;
	Soort soort;
	double alcohol;
	@NumberFormat(style = Style.NUMBER)
	BigDecimal prijs;
	
	public Bier(int id, String naam, int brouwerid, Soort soort, double alcohol, BigDecimal prijs) {
		this.id = id;
		this.naam = naam;
		this.brouwerid = brouwerid;
		this.soort = soort;
		this.alcohol = alcohol;
		this.prijs = prijs;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public int getBrouwerid() {
		return brouwerid;
	}

	public Soort getSoort() {
		return soort;
	}

	public double getAlcohol() {
		return alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setBrouwerid(int brouwerid) {
		this.brouwerid = brouwerid;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	
	
	
	
	
}
