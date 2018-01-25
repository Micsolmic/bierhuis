package be.vdab.entities;


import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;



public class Bier{
	
	
	int id;
	String naam;
	int brouwerid;
	String brouwernaam;
	Soort soort;
	@NumberFormat(style = Style.NUMBER)
	double alcohol;
	@NumberFormat(pattern = "#,##0.##")
	BigDecimal prijs;
	int aantal;
	
	public Bier(int id, String naam, int brouwerid, String brouwernaam, Soort soort, double alcohol, BigDecimal prijs, int aantal) {
		this.id = id;
		this.naam = naam;
		this.brouwerid = brouwerid;
		this.brouwernaam = brouwernaam;
		this.soort = soort;
		this.alcohol = alcohol;
		this.prijs = prijs;
		this.aantal = aantal;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
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

	public String getBrouwernaam() {
		return brouwernaam;
	}

	public void setBrouwernaam(String brouwernaam) {
		this.brouwernaam = brouwernaam;
	}
	
	
	
	
	
	
}
