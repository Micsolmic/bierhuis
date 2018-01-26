package be.vdab.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/success") 
public class SuccessController {
	private static final String SUCCESS_VIEW = "success";
	@GetMapping("{bestelbonid}")
	ModelAndView getSuccessView(@PathVariable int bestelbonid, HttpSession session) {
		session.removeAttribute("mandje");
		return new ModelAndView(SUCCESS_VIEW).addObject("bestelbonid", bestelbonid);
	}

	
}





