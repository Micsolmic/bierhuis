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

@Controller
@RequestMapping("/winkelwagen")
// @SessionAttributes("mandje")
public class WinkelwagenController {

	private static final String WINKELWAGEN_VIEW = "winkelwagen";

	@GetMapping
	ModelAndView getBrouwersView(@SessionAttribute(name = "mandje") Mandje mandje, Model model) {
		
		model.addAttribute("bestelbon", new Bestelbon());
		
		return new ModelAndView(WINKELWAGEN_VIEW).addObject(mandje);
		
	}

	@PostMapping(params = {"naam"}) 
	String handle(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/winkelwagen";
		}else {
			System.out.println("hiiiaa");
			return "redirect:/success";
		}
	}

}
