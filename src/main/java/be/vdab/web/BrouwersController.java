package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwersService;

// enkele imports ...
@Controller 
@RequestMapping("/brouwers") 
class BrouwersController {
	
private final BrouwersService brouwersService;

BrouwersController(BrouwersService bs){
	brouwersService = bs;
}
	
private static final String BROUWERS_VIEW = "brouwers";

@GetMapping
ModelAndView getBrouwersView() {
return new ModelAndView(BROUWERS_VIEW).addObject("brouwers", brouwersService.alfabetisch());
}
}