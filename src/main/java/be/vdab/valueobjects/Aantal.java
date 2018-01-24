package be.vdab.valueobjects;

import org.hibernate.validator.constraints.Range;

public class Aantal {

	@Range(min = 0, max = 100)
	int aantal;

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public int getAantal() {
		return aantal;
	}
}
