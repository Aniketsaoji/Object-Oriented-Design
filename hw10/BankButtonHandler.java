package hw.hw10;

public interface BankButtonHandler {
	public void buttonNewAccount(String name);
	public void buttonGetAccount(String name);
	public void buttonDeposit(int dolla);
	public void buttonWithdraw(int dolla);
	public void buttonShowBalance();
}
