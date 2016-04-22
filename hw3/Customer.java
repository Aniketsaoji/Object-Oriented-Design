package hw.hw3;

public class Customer {
   private int arrivalTime;
   private int serviceTime;
   private ItemDistribution id;
   private Cashier cashier;
   
   public Customer(int t, ItemDistribution id, Cashier c) {
	  this.id = id;
	  this.cashier = c;
      arrivalTime = t;
      int n = id.calculate();
      serviceTime = n + 6;
   }
   
   public void elapseOneSecond() {
//	   if(cashier.getSpeed() == "Normal"){
//		   serviceTime--;
//	   }
//	   else{
//		   serviceTime-=2;
//	   }
	   cashier.serve(this);
   }
   
   public boolean isFinished() {
   		return serviceTime < 0;
   }
   
   public int arrivalTime() {
      return arrivalTime;
   }

public int getServiceTime() {
	return serviceTime;
}

public void setServiceTime(int serviceTime) {
	this.serviceTime = serviceTime;
}
   
   
}