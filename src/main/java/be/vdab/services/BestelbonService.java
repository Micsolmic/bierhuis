package be.vdab.services;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bestelbon;
import be.vdab.repositories.BestelbonRepository;
import be.vdab.repositories.BestelbonlijnRepository;

@Service
public class BestelbonService {

	
	private BestelbonRepository bbonrepo;
	
	public BestelbonService(BestelbonRepository bbonrepo) {
		this.bbonrepo = bbonrepo;
	}
	
	public int create(Bestelbon bbon) {
		return bbonrepo.create(bbon);
	}
	
}
