package hw.hw6;

import java.awt.Color;

//ComponentStyleFactory is a basic factory class
//the method ComponentStyleFactory.instance is a static factory method

public class ComponentStyleFactory {
	
	private ComponentStyleFactory(){
		
	}
	
	public static ComponentStyleFactory instance(){
		return new ComponentStyleFactory();
	}
	
	public static ComponentStyler create(Color c1, Color c2){
		return new ComponentStyler(c1,c2);
		
	}
	
	public static ComponentStyler createMonochrome(Color color){
		int newRed = (int)(color.getRed() + ((255 - color.getRed())*0.75));
		int newGreen = (int)(color.getGreen() + ((255 - color.getGreen())*0.75));
		int newBlue = (int)(color.getBlue() + ((255 - color.getBlue())*0.75));
		Color lightercolor = new Color(newRed, newGreen, newBlue);
		return new ComponentStyler(color, lightercolor);
		
	}

}
