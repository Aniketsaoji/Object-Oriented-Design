package hw.hw5;

public class Bullish implements StockAnalyst{
	private StockInfo si;

	public Bullish(StockInfo si){
		this.si = si;
	}
	public StockInfo getStockInfo(){
		return this.si;
	}
	
	public double confidenceLevel(){
		return 0.60;
	}
	public String reasons(){
		return "Based on the market as a whole";
	}

}
