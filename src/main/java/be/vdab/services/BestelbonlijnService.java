package be.vdab.services;

import org.springframework.stereotype.Service;

import be.vdab.repositories.BestelbonlijnRepository;

@Service
public class BestelbonlijnService {

	private BestelbonlijnRepository bblR;
	
	public BestelbonlijnService(BestelbonlijnRepository bblR) {
		this.bblR = bblR;
	}
	
	
}
