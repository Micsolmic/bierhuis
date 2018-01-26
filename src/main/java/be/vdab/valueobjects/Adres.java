package be.vdab.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Adres implements Serializable {

	static final long SerialVersionUID = 5L;
	
	@Size(min=2, max=30, message="   bestaat niet")
	private String straat;	
	@Min(value=1, message="   begint bij 1")
	private int huisNr;
	@Min(value=1000, message="    begint bij 1000")
	private int postcode;
	@Size(min=2, max=30, message="    bestaat niet")
	private String gemeente;
	
	
	
	
	public Adres() {
		straat = "";
		huisNr = 1;
		
		postcode = 9000;
		gemeente = "";
	}
	
	
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
