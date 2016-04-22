package hw.hw1;

//Author: David Schmetterling

import java.util.*;

public class BetterDiningHallSimulation {
	private static final int SIMULATION_TIME = 10000;  // A simulation is for 10,000 seconds.
	private static final int CUST_ARRIVAL_PCT = 19;    // There is a 19% chance a customer arrives each second.
	private static Customer thecustomer = new Customer();
	private static CashRegister cashRegister = new CashRegister();

	public static void main(String[] args) {
		// First, initialize the cash register arrays.
		
		for (int r=0; r<=1; r++) {
			thecustomer.initialize(r);
			cashRegister.initialize(r);
		}

		// Then perform the simulation for the specified number of seconds.
		for (int t=0; t<SIMULATION_TIME; t++) {
			if (thecustomer.aCustomerArrives()) {
				// The new customer goes into the smaller line.
				int chosenRegister = thecustomer.whatRegister();
				thecustomer.addArrivalTimes(chosenRegister, t);
				thecustomer.addServiceTimes(chosenRegister, t, cashRegister);
			}

			for (int r=0; r<=1; r++)
				CashRegister.elapseOneSecond(r, t);  // Simulate each register for one second.
		}

		// Print out the statistics.
		for (int r=0; r<=1; r++) {
			System.out.println("Register " + r);
			System.out.println("\tNumber of arrivals = " + cashRegister.getCustomersServed()[r]);
			System.out.println("\tAverage wait time = " + (cashRegister.getTotalWaitTimes()[r] / cashRegister.getCustomersServed()[r]));
		}
	}
	
	
}