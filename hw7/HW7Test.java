package hw.hw7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class HW7Test {
	private ArithmeticExpression allMenus;
	private static int number = 0;
	private static int max = 0;
	
	public static void main(String args[]){
		
		//Some numbers
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		Integer six = new Integer(6);
		Integer seven = new Integer(7);
		Integer eight = new Integer(8);
		
		//Multiple operator tree
		PLUS plus = new PLUS();
		PRODUCT product = new PRODUCT();
		product.add(three);
		product.add(four);
		plus.add(one);
		plus.add(product);
		
		System.out.println(plus.toString());
		System.out.println(plus.evaluate());
		prob4a(plus);
		prob4aprintreset();
		Consumer<ArithmeticExpression> consumer = (ArithmeticExpression ae) -> {if(ae instanceof Variable) System.out.print(ae.toString()+", ");};
		System.out.println("External Iteration of all variables:");
		plus.prob4b(consumer);
		System.out.println('\n');
		
		//Multiple operator tree
		PLUS plus2 = new PLUS();
		PRODUCT product2 = new PRODUCT();
		PLUS plus3 = new PLUS();
		PRODUCT product3 = new PRODUCT();
		plus3.add(product3);
		plus3.add(eight);
		product3.add(one);
		product3.add(six);
		product2.add(plus3);
		product2.add(four);
		plus2.add(one);
		plus2.add(product2);

		System.out.println(plus2.toString());
		System.out.println(plus2.evaluate());
		prob4a(plus2);
		prob4aprintreset();
		System.out.println("External Iteration of all variables:");
		plus2.prob4b(consumer);
		System.out.println('\n');
		
		// Variable Test
		Variable x = new Variable("x");
		Integer twelve = new Integer(12);
		PLUS plus1 = new PLUS();
		PRODUCT product1 = new PRODUCT();
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("x", twelve);
		product1.add(three);
		product1.add(four);
		plus1.add(x);
		plus1.add(product1);
		System.out.println(plus1.toString());
		System.out.println(plus1.eval(m));
		prob4a(plus1);
		prob4aprintreset();
		System.out.println("External Iteration of all variables:");
		plus1.prob4b(consumer);
		System.out.println('\n');
	}
	
	public static void prob4a(ArithmeticExpression top){
		Iterator<ArithmeticExpression> tree = top.iterator();
		while(tree.hasNext()){
			ArithmeticExpression temp = tree.next();
			if(temp instanceof Integer){
				number++;
				if(temp.evaluate() > max){
					max = temp.evaluate();
				}
			}
			else{
				prob4a(temp);
			}
		}
//		for(ArithmeticExpression ae : top){
//			System.out.println(ae.getClass());
//			if(ae instanceof Integer){
//				number++;
//				System.out.println("Added 1 to get: " + number);
//				if(ae.evaluate() > max){
//					max = ae.evaluate();
//				}
//			}
//			else{
//				prob4a(ae);
//			}
//		}	
	}
	public static void prob4aprintreset(){
		System.out.println("There are " + number + " Integers");
		System.out.println("The max Integer is " + max);
		number = 0;
		max = 0;
	}


}
