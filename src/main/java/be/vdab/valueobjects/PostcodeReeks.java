package be.vdab.valueobjects;

public class PostcodeReeks {   private int vanpostcode;
 private int totpostcode;   // Je maakt getters en setters voor de private variabelen  
 public boolean bevat(int postcode) {   
	 // bevat de reeks een bepaalde postcode ? (gebuikt in de repository layer)  
	 return postcode >= vanpostcode && postcode <= totpostcode;   
	 }
 
 }