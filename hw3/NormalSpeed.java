package hw.hw3;

public class NormalSpeed implements Cashier{
	private String speed = "Normal";

	public String getSpeed() {
		return speed;
	}
	
	public void serve(Customer c){
		c.setServiceTime(c.getServiceTime()-1);
	}

}
