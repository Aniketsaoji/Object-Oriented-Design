package hw.hw7;

import java.util.Map;
import java.util.function.Consumer;

public interface ArithmeticExpression extends Iterable<ArithmeticExpression> {
	// A menu component
	
	public String toString();
	public int evaluate();
	public int eval(Map<String,Integer> m);
	public void add(ArithmeticExpression other);
	public default void prob4b(Consumer<ArithmeticExpression> f) {
		f.accept(this);
		forEach(ae->ae.prob4b(f));
	}

}
