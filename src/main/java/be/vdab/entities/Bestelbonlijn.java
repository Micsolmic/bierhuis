package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


@Entity
@Table(name = "bestelbonlijnen")
public class Bestelbonlijn {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bestelbonid;
	int bierid;
	int aantal;
	@NumberFormat(style = Style.NUMBER)
	BigDecimal prijs;
	
	public Bestelbonlijn() {};
	
	public Bestelbonlijn(int bestelbonid, int bierid, int aantal, BigDecimal prijs) {
		super();
		this.bestelbonid = bestelbonid;
		this.bierid = bierid;
		this.aantal = aantal;
		this.prijs = prijs;
	}
	public int getBestelbonid() {
		return bestelbonid;
	}
	public int getBierid() {
		return bierid;
	}
	public int getAantal() {
		return aantal;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public void setBestelbonid(int bestelbonid) {
		this.bestelbonid = bestelbonid;
	}
	public void setBierid(int bierid) {
		this.bierid = bierid;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	
	
}
