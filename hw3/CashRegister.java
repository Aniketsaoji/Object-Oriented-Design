package hw.hw3;

import java.util.*;

public class CashRegister {
   private List<Customer> custs = new LinkedList<Customer>();
   private int numServed = 0;
   private int totalWaitTime = 0;
   private Customer currentCust = null;
   private Cashier strategy;
   private ItemDistribution id;
   
   public CashRegister(Cashier strategy, ItemDistribution id){
	   this.strategy = strategy;
	   this.id = id;
   }
   
   public void addCustomer(int t) {
   		Customer c = new Customer(t, id, strategy);
      custs.add(c);
      if (currentCust == null)
      		currentCust = c;
   }
   
   public void elapseOneSecond(int currentTime) {
		// Return if there is no current customer.
		if (currentCust == null)
			return;

		// Otherwise, process the current customer.
		currentCust.elapseOneSecond();
		if (currentCust.isFinished()) {
			numServed++;
			totalWaitTime += currentTime - currentCust.arrivalTime();
			
			// Remove the finished customer and make the next customer current.
			custs.remove(0);
			currentCust = custs.size() > 0 ? custs.get(0) : null;
		}
   }
   
   public int size() { 
      return custs.size(); 
   }
   
   public int customersServed() { 
      return numServed; 
   }
   
   public int avgWaitTime() { 
      return totalWaitTime / numServed; 
   }

	public Cashier getStrategy() {
		return strategy;
	}
   
   
}
