package hw.hw7;

import java.util.Iterator;
import java.util.Map;

public class Variable implements ArithmeticExpression{
	//A MenuItem
	private String variable;
	
	public Variable(String variable){
		this.variable = variable;
		
	}
	
	public int evaluate() {
		throw new UnsupportedOperationException() ;
	}
	
	public String toString(){
		return "" + variable;
	}

	public Iterator<ArithmeticExpression> iterator() {
		return new NullIterator();
	}
	
	public int eval(Map<String,Integer> m){
		Integer theint = m.get(variable);
		return theint.evaluate();
	}
	
	public void add(ArithmeticExpression other) {
		throw new UnsupportedOperationException();
	}
}

