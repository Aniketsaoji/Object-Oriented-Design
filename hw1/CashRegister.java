package hw.hw1;

// Author: David Schmetterling

import java.util.LinkedList;
import java.util.List;

public class CashRegister {
	private static List<Customer> customers = new LinkedList<Customer>();
	
	// statistics about the two cash registers
		private static int[] customersServed = new int[2];
		private static int[] totalWaitTimes = new int[2];
	
	public int howManyItems() {
		int n = (int) (Math.random() * 10);
		return n + 1;
	}
	
	public int[] getCustomersServed() {
		return customersServed;
	}

	public int[] getTotalWaitTimes() {
		return totalWaitTimes;
	}

	public void initialize(int r){
		customersServed[r] = 0;
		totalWaitTimes[r]  = 0;
	}
	
	public static void done(int reg, int currentTime, Customer tc){
		customersServed[reg]++;
		totalWaitTimes[reg] += currentTime - tc.getArrivalTimes()[reg].get(0);
	}
	
	public static void addCustomer(Customer e){
		customers.add(e);
	}
	
	public static void elapseOneSecond(int reg, int currentTime) {
		// If the list is empty, there are no customers to process.
		if (customers.get(0).getArrivalTimes()[reg].size() == 0)
			return;

		// Otherwise, the first customer in line gets processed.
		int timeLeft = customers.get(0).getServiceTimes()[reg].get(0) - 1;
		if (timeLeft > 0) { 
			customers.get(0).getServiceTimes()[reg].set(0, timeLeft);
		}
		else { // We are done with this customer.
			// First update the register's statistics.
			done(reg, currentTime, customers.get(0));

			// Then remove the customer.
			customers.get(0).removeCustomer(reg);
		}
	}

}
