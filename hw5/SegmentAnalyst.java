package hw.hw5;

public class SegmentAnalyst extends AnalystDecorator{
	
	public SegmentAnalyst(StockAnalyst component){
		super(component);
	}
	
	public double confidenceLevel(){
		return (getComponent().confidenceLevel() + calculateConfidenceLevel())/2;
	}
	public String reasons(){
		return getComponent().reasons() + '\n' + "The type of stock was: " + calculateMarketSegment();
	}
	
	public double calculateConfidenceLevel(){
		String marketsegment = calculateMarketSegment();
		if(marketsegment.equals("auto")){
			return 0.20;
		}
		else if(marketsegment.equals("technology")){
			return 0.80;
		}
		else{
			return 0.00;
		}
	}
	public String calculateMarketSegment(){
		String marketsegment = getComponent().getStockInfo().get("marketsegment");
		return marketsegment;
	}

	public StockInfo getStockInfo() {
		return getComponent().getStockInfo();
	}

}
