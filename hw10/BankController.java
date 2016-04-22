package hw.hw10;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BankController implements BankButtonHandler{
	private BankView view;
	private Account current;
	private Service service;
	
	public BankController(BankView bv) throws MalformedURLException, RemoteException, NotBoundException{
		this.view = bv;
		service = (Service) Naming.lookup("rmi://localhost/BankService");
		bv.addHandler(this);
	}
	
	public void buttonNewAccount(String name){
		try{
			service.makeBankAccount(name);
			current = (Account) service.getBankAccount(name);
			view.forceupdate();
		} catch (RemoteException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		
	}
	
	public void buttonGetAccount(String name){
		if(current == null){
			System.out.println("Account not selected");
		}
		else{
			try {
				current = service.getBankAccount(name);
			} catch (RemoteException e) {
				System.out.println("Exception");
				e.printStackTrace();
			}
		}
	}
	
	public void buttonDeposit(int dolla){
		if(current != null) {
			current.deposit(dolla);
		}
		else{
			System.out.println("Account doesn't exist");
		}
	}
	
	public void buttonWithdraw(int dolla){
		if(current.getCurrentBalance() != 0.0){
			current.withdraw(dolla);
		}
		else{
			System.out.println("Cannot Withdraw");
		}
	}
	
	public void buttonShowBalance(){
		if(current.getCurrentBalance() == 0.0){
			System.out.println("Account has no money");
		}
		else{
			int balance = current.getCurrentBalance();
			view.showBalance(balance);
		}
	}

}
