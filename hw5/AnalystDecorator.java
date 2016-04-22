package hw.hw5;

public abstract class AnalystDecorator implements StockAnalyst{
	private StockAnalyst component;
	
	public AnalystDecorator(StockAnalyst component){
		this.component = component;
	}
	
	protected StockAnalyst getComponent(){
		return component;
	}

	public abstract double confidenceLevel();
	public abstract String reasons();
}
