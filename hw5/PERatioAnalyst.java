package hw.hw5;

public class PERatioAnalyst extends AnalystDecorator{
	
	public PERatioAnalyst(StockAnalyst component){
		super(component);
	}
	public double confidenceLevel(){
		return (getComponent().confidenceLevel() + calculateConfidenceLevel())/2;
	}
	public String reasons(){
		return getComponent().reasons() + '\n' + "Calculated a Price-Earnings ratio of " + calculatePEratio();
	}
	
	public double calculateConfidenceLevel(){
		double ratio = calculatePEratio();
		if(ratio == 12.0){
			return 0.50;
		}
		else if(ratio > 12.0){
			return 0.75;
		}
		else if(ratio < 12.0){
			return 0.25;
		}
		else{
			return 0.00;
		}
	}
	public double calculatePEratio(){
		double earnings = Double.parseDouble(getComponent().getStockInfo().get("earnings"));
		double shareprice = Double.parseDouble(getComponent().getStockInfo().get("shareprice"));
		return shareprice / earnings;
	}

	public StockInfo getStockInfo() {
		return getComponent().getStockInfo();
	}

}
