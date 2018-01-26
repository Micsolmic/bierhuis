package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.services.BestelbonlijnService;

@Controller
@RequestMapping("/winkelwagen")
// @SessionAttributes("mandje")
public class WinkelwagenController {

	private static final String WINKELWAGEN_VIEW = "winkelwagen";
	private final BestelbonlijnService bblserv;
	private final BestelbonService bbserv;
	
	
	public WinkelwagenController(BestelbonlijnService b, BestelbonService bb) {
		bblserv = b;
		bbserv = bb;
	}
	
	@GetMapping
	ModelAndView getBrouwersView(@SessionAttribute(name = "mandje") Mandje mandje, Model model) {
		
		model.addAttribute("bestelbon", new Bestelbon());
		
		return new ModelAndView(WINKELWAGEN_VIEW).addObject(mandje);
		
	}

	@PostMapping(params = {"naam"}) 
	ModelAndView handle(@Valid Bestelbon bestelbon, BindingResult bindingResult, @SessionAttribute(name = "mandje") Mandje mandje) {
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/winkelwagen").addObject(mandje);
		}else {
			System.out.println("hiiiaa");
			
			int id = bbonNaarDB(bestelbon);
		
			int bevestigdBbonNummer = bblijnenNaarDB(mandje, id);
			
			System.out.println("tot hier");
			
			
			return new ModelAndView("redirect:/success/"+bevestigdBbonNummer);
		}
	}

	
	public int bblijnenNaarDB(Mandje mandje, int id) {
		
		bblserv.bblijnenNaarDB(mandje.getInhoud(), id);
		return id;
	}
	
	public int bbonNaarDB(Bestelbon bestelbon) {
		
		return bbserv.create(bestelbon);
		
	}
}
