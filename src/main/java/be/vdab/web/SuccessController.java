package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/success") 
public class SuccessController {
	private static final String SUCCESS_VIEW = "success";
	@GetMapping
	ModelAndView getIndexView() {
	return new ModelAndView(SUCCESS_VIEW);
	}

	
}





