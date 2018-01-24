package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/winkelwagen")
@SessionAttributes("mandje")
public class WinkelwagenController {

	private static final String WINKELWAGEN_VIEW = "winkelwagen";
	private final Mandje mandje;
	
	public WinkelwagenController(Mandje mandje) {
		this.mandje = mandje;
	}	
	
	
	@GetMapping
	ModelAndView getBrouwersView() {
	return new ModelAndView(WINKELWAGEN_VIEW);
	}

	
}
