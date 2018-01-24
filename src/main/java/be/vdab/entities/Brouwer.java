package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	
	int id;
	String naam;
	@NumberFormat(style = Style.NUMBER)
	BigDecimal omzet;
	Adres adres;
	
	
	
	
	
	public Brouwer(int id, String naam, BigDecimal omzet, Adres adres) {
		super();
		this.id = id;
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
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
	public BigDecimal getOmzet() {
		return omzet;
	}
	public void setOmzet(BigDecimal omzet) {
		this.omzet = omzet;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brouwer other = (Brouwer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
