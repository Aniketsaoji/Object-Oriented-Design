package hw.hw10;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

//Part of server
//1 of 2 remote classes
//should manage the bank accounts
//support methods to create a new account and retrieve an existing account

public class BankService extends UnicastRemoteObject implements Service {
	private HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();
	
	public BankService() throws RemoteException{
		// FOR TESTING PURPOSES
		BankAccount temp = new BankAccount("steve");
		temp.deposit(20);
		accounts.put("steve", temp);
	}
	
	public BankAccount getBankAccount(String name) throws RemoteException {
		return accounts.get(name);
	}
	
	public void makeBankAccount(String name) throws RemoteException {
		BankAccount temp = new BankAccount(name);
		accounts.put(name, temp);
	}
}
