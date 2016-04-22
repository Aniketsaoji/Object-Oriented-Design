package hw.hw5;

public class Bearish implements StockAnalyst{
	private StockInfo si;
	
	public Bearish(StockInfo si){
		this.si = si;
	}
	
	public StockInfo getStockInfo(){
		return this.si;
	}
	
	public double confidenceLevel(){
		return 0.40;
	}
	public String reasons(){
		return "Based on the market as a whole";
	}

}
