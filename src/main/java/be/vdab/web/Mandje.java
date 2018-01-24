package be.vdab.web;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class Mandje implements Serializable{

	private static final long SerialVersionUID = 1L;
	
	HashMap<Integer,Integer> inhoud = new HashMap<>();
	
	public HashMap<Integer,Integer> getInhoud() {return inhoud;}

	public void setInhoud(HashMap<Integer, Integer> inhoud) {
		this.inhoud = inhoud;
	}
	
}
