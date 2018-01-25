package be.vdab.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import be.vdab.entities.Bier;


@Component
@SessionScope
public class Mandje implements Serializable{

	private static final long SerialVersionUID = 1L;
	
	private List<Bier> inhoud = new ArrayList<>();
	
	@NumberFormat(pattern = "#,##0.##")
	private BigDecimal totaal = BigDecimal.ZERO;
	
	



	public void updateSom(Bier b) {
		
		totaal = totaal.add(BigDecimal.valueOf(Long.valueOf(b.getAantal())).multiply(b.getPrijs()));
		
	}
			
			
	public List<Bier> getInhoud() {return inhoud;}

	public void addBier(Bier bier) {
		this.inhoud.add(bier);
		updateSom(bier);
		
	}

	public BigDecimal getTotaal() {
		return totaal;
	}


	public void setTotaal(BigDecimal totaal) {
		this.totaal = totaal;
	}


	public void setInhoud(List<Bier> inhoud) {
		this.inhoud = inhoud;
	}
	
	
	
}
