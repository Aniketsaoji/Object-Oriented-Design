package hw.hw10;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Part of server
//1 of 2 remote classes
//support methods to deposit, withdraw, and retrieve the current balance

public class BankAccount extends UnicastRemoteObject implements Account{
	private String userName;
	private int balance = 0;
	
	public BankAccount(String name) throws RemoteException {
		this.userName = name;
	}
	
	public void deposit(int dolla){
		balance += dolla;
	}
	
	public void withdraw(int dolla){
		balance -= dolla;
	}
	
	public int getCurrentBalance(){
		return balance;
	}

}
