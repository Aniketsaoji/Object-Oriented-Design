package hw.hw5;

public class Neutral implements StockAnalyst{
	private StockInfo si;
	
	public Neutral(StockInfo si){
		this.si = si;
	}
	
	public StockInfo getStockInfo(){
		return this.si;
	}
	
	public double confidenceLevel(){
		return 0.50;
	}
	public String reasons(){
		return "Based on the market as a whole";
	}

}
