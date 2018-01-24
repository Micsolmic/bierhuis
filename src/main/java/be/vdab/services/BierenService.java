package be.vdab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bier;
import be.vdab.repositories.BierenRepository;

@Service
public class BierenService {

	private BierenRepository bierenRepo;
	
	
	public BierenService(BierenRepository br) {
		bierenRepo = br;
	}
	
	public List<Bier> alleBierenVanBrouwer(int id){
		
		return bierenRepo.alleBierenVanBrouwer(id);
		
	}
	
	public Optional<Bier> read(int id) {
		return bierenRepo.read(id);
	}
}
