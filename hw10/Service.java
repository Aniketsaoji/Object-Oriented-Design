package hw.hw10;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
	public BankAccount getBankAccount(String name) throws RemoteException;
	public void makeBankAccount(String name) throws RemoteException;
}
