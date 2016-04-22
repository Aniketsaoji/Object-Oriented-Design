package hw.hw10;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Account extends Serializable{
	public void deposit(int dolla);
	public void withdraw(int dolla);
	public int getCurrentBalance();
}
