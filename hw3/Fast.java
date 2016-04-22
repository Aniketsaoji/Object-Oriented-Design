package hw.hw3;

public class Fast implements Cashier{
	private String speed = "Fast";

	public String getSpeed() {
		return speed;
	}
	
	public void serve(Customer c){
		c.setServiceTime(c.getServiceTime()-2);
	}

}
