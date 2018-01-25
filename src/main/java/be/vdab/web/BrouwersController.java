package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
import be.vdab.services.BierenService;
import be.vdab.services.BrouwersService;

// enkele imports ...
@Controller 
@SessionAttributes("mandje")
@RequestMapping("/brouwers") 
class BrouwersController {
	
private final BrouwersService brouwersService;
private final BierenService bierenService;


BrouwersController(BrouwersService bs, BierenService bierens){
	brouwersService = bs;
	bierenService = bierens;
	
}

@ModelAttribute("mandje")
public Mandje getMandje () {
    return new Mandje();
}

	
private static final String BROUWERS_VIEW = "brouwers";
private static final String BROUWER_VIEW = "brouwer";
private static final String BIERINFO_VIEW = "bierinfo";
private static final String REDIRECT_NAAR_WINKELWAGEN = "redirect:/winkelwagen";

@GetMapping
ModelAndView getBrouwersView() {
return new ModelAndView(BROUWERS_VIEW).addObject("brouwers", brouwersService.alfabetisch());
}

@GetMapping("{id}")
ModelAndView read(@PathVariable int id) {
	ModelAndView modelAndView = new ModelAndView(BROUWER_VIEW);
	brouwersService.read(id).ifPresent(brouwer -> modelAndView.addObject(brouwer)
			.addObject("bieren", bierenService.alleBierenVanBrouwer(id)));
	
	return modelAndView;
}



@GetMapping("{brouwerid}/{bierid}")
ModelAndView read(@PathVariable int brouwerid, @PathVariable int bierid) {
	ModelAndView modelAndView = new ModelAndView(BIERINFO_VIEW);
	bierenService.read(bierid).ifPresent(bier -> modelAndView.addObject(bier));	
	return modelAndView;
}



@PostMapping(value="/{brouwerid}/{bierid}", params = {"aantal", "bierid"})
ModelAndView voegToe(int bierid, int aantal, Mandje mandje) {
	ModelAndView modelAndView = new ModelAndView(REDIRECT_NAAR_WINKELWAGEN);
	Bier bierInMandje = bierenService.read(bierid).get();
	bierInMandje.setAantal(aantal);
	mandje.addBier(bierInMandje);
	return modelAndView;
}



}