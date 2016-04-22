package hw.hw3;

import java.util.Random;

public class DiningHall {
	private static final int CUST_ARRIVAL_PCT = 90;    // There is a 19% chance a customer arrives each second.
	private CashRegister[] registers;
	int total = 0;

	public DiningHall(int normal, int fast, ItemDistribution id) {
		total = normal + fast;
		registers = new CashRegister[total];
		for (int r=0; r<normal; r++){
			Cashier norm = new NormalSpeed();
			registers[r] = new CashRegister(norm, id);
		}
		for (int r=normal; r<total; r++){
			Cashier quick = new Fast();
			registers[r] = new CashRegister(quick, id);
		}
		//Testing
//		for(CashRegister cr : registers){
//			System.out.println(cr.toString());
//		}
	}

	public void elapseOneSecond(int t) {
		if (aCustomerArrives()) {
			// The new customer goes into the smaller line.
			//int chosenRegister = registers[0].size() < registers[1].size() ? 0 : 1;
			int min = registers[0].size();
			int chosen = 0;
			for(int r = 1; r < total; r++){
				int temp = registers[r].size();
				if(temp == min){
					int min1 = 1;
					int max1 = 2;
					Random r2 = new Random();
					int i2 = r2.nextInt(max1 - min1 + 1) + min1;
					if(i2 == 2){
						min = temp;
						chosen = r;
					}
				}
				else if(temp < min){
					min = temp;
					chosen = r;
				}
			}
			registers[chosen].addCustomer(t);
		}
		for (int r=0; r<total; r++){
			registers[r].elapseOneSecond(t);  // Simulate each register for one second.
		}
			
	}

	public void printStatistics() {
		for (int r=0; r<total; r++) {
			CashRegister reg = registers[r];
			System.out.println("Register " + r);
			System.out.println("Register Speed: " + registers[r].getStrategy().getSpeed());
			System.out.println("\tNumber of arrivals = " + reg.customersServed());
			System.out.println("\tAverage wait time = " + reg.avgWaitTime());
		}
	}

	private boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}
}
