package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.repositories.BierenRepository;



// enkele imports ...
@Controller 
@RequestMapping("/") 
class IndexController {
private final BierenRepository brepo;
private static final String INDEX_VIEW = "index";

public IndexController(BierenRepository brepo) {
	
	this.brepo = brepo;
	
}

@GetMapping
ModelAndView getIndexView() {
return new ModelAndView(INDEX_VIEW).addObject("beerCount", brepo.countBieren());
}







}
