package hw.hw7;

import java.util.Iterator;
import java.util.Map;

public class Integer implements ArithmeticExpression{
	//A MenuItem
	private int theint;
	
	public Integer(int theint){
		this.theint = theint;
	}
	
	public int evaluate() {
		return theint;
	}
	
	public int eval(Map<String,Integer> m) {
		return theint;
	}
	
	public String toString(){
		return "" + theint;
	}

	public Iterator<ArithmeticExpression> iterator() {
		return new NullIterator();
	}

	public void add(ArithmeticExpression other) {
		throw new UnsupportedOperationException();
	}
	

}
