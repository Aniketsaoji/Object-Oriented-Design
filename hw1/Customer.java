package hw.hw1;

//Author: David Schmetterling

import java.util.LinkedList;
import java.util.List;

public class Customer {
	private static final int CUST_ARRIVAL_PCT = 19;    // There is a 19% chance a customer arrives each second.
	// info about customers waiting at the two cash registers
	private static List<Integer>[] arrivalTimes = (List<Integer>[]) new List[2];
	private static List<Integer>[] serviceTimes = (List<Integer>[]) new List[2];

	public List<Integer>[] getArrivalTimes() {
		return arrivalTimes;
	}

	public List<Integer>[] getServiceTimes() {
		return serviceTimes;
	}

	public boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}
	
	public void initialize(int register){
		arrivalTimes[register] = new LinkedList<Integer>();
		serviceTimes[register] = new LinkedList<Integer>();
		CashRegister.addCustomer(this);
	}
	
	public int whatRegister(){
		return arrivalTimes[0].size() < arrivalTimes[1].size() ? 0 : 1; 
	}
	
	public void addArrivalTimes(int register, int time){
		arrivalTimes[register].add(time);
	}
	
	public void addServiceTimes(int register, int time, CashRegister cr){
		serviceTimes[register].add(cr.howManyItems() + 5);
	}

	public static void setServiceTimes(List<Integer>[] serviceTimes) {
		Customer.serviceTimes = serviceTimes;
	}
	public void removeCustomer(int reg){
		arrivalTimes[reg].remove(0);
		serviceTimes[reg].remove(0);
	}

}
