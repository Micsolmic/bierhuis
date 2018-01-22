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

import be.vdab.valueobjects.Persoon;

// enkele imports ...
@Controller 
@RequestMapping("/") 
class IndexController {
private static final String INDEX_VIEW = "index";

@GetMapping
ModelAndView getIndexView() {
return new ModelAndView(INDEX_VIEW);
}



@GetMapping(params = {"naam", "leeftijd"})
ModelAndView controleerInput(Persoon persoon, 
BindingResult bindingResult) { 
ModelAndView modelAndView = new ModelAndView(INDEX_VIEW);
if ( ! bindingResult.hasErrors()) { 
modelAndView.addObject("bindingresult","de invoer is correct");
}else {modelAndView.addObject("bindingresult","de invoer is fout");}
return modelAndView;
}

@InitBinder("persoon") 
void initBinderPostcodeReeks(DataBinder dataBinder) { 
dataBinder.setRequiredFields("naam", "leeftijd"); 
}

}
