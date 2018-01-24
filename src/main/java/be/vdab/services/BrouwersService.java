package be.vdab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwersRepository;

@Service
public class BrouwersService {

	private BrouwersRepository br;
	
	public BrouwersService(BrouwersRepository br) {
		this.br = br;
	}
	
	public List<Brouwer> alfabetisch(){
		
		return br.alfabetisch();
		
	}
	
	
}
