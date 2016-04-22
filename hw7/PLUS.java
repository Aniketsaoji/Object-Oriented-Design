package hw.hw7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PLUS implements ArithmeticExpression{
	// A Menu
	private List<ArithmeticExpression> components = new ArrayList<ArithmeticExpression>();
	
	public PLUS(){
		//No arg constructor
	}
	
	public List<ArithmeticExpression> getComponents() {
		return components;
	}
	
	public Iterator<ArithmeticExpression> iterator() {
		return components.iterator();
	} 	
	
	public int evaluate(){
		int addition = 0;
		//if no children:
		if(components == null){
			return 0;
		}
		else{
			for(ArithmeticExpression ae : components){
					addition += ae.evaluate();
			}
			return addition;
		}
	}
	
	public String toString(){
		String theString = "(" + components.get(0);
		if(components == null){
			return "";
		}
		else{
			for(int i = 1; i< components.size(); i++){
				theString += "+" + components.get(i).toString();
			}
		return theString += ")";
		}	
	}
	
	//add (for adding another argument to the operator)
	public void add(ArithmeticExpression other){
		components.add(other);
	}
	
	public int eval(Map<String,Integer> m){
		int addition = 0;
		//if no children:
		if(components == null){
			return 0;
		}
		else{
			for(ArithmeticExpression ae : components){
					addition += ae.eval(m);
			}
			return addition;
		}
	}

}
