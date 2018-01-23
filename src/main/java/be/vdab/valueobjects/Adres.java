package be.vdab.valueobjects;

import java.io.Serializable;

public class Adres implements Serializable {

	static final long SerialVersionUID = 5L;
	
	private String straat;
	private int huisNr;
	private int postcode;
	private String gemeente;
	
	
	
	
	
	
	
	public Adres(String straat, int huisNr, int postcode, String gemeente) {
		super();
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public int getHuisNr() {
		return huisNr;
	}
	public void setHuisNr(int huisNr) {
		this.huisNr = huisNr;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getGemeente() {
		return gemeente;
	}
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	
	
}
