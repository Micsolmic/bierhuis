package be.vdab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bier;
import be.vdab.repositories.BestelbonlijnRepository;

@Service
public class BestelbonlijnService {

	private BestelbonlijnRepository bblR;
	
	public BestelbonlijnService(BestelbonlijnRepository bblR) {
		this.bblR = bblR;
	}
	
	public void bblijnenNaarDB(List<Bier> bblijnen, int bestelbonid) {
		
		bblR.bblijnenNaarDB(bblijnen, bestelbonid);
		
	}
	
}
