package hw.hw4;

public class ForecastDisplay implements WeatherDisplay {
	private float currentpressure = 29.27f;
	private float oldpressure;
	private WeatherOutput wo;

	public ForecastDisplay(WeatherData wd) {
		wd.registerObserver(this);
	}

	public void setOutputStrategy(WeatherOutput wo) {
		this.wo = wo;
	}

	public void update(WeatherData wd) {
		oldpressure = currentpressure;
		currentpressure = wd.getPressure();
		display();
	}

	public void display() {
		String result = "";
		result += "Forecast: ";
		result += '\n';
		if (currentpressure > oldpressure)
			result += "Improving weather on the way!";
		else if (currentpressure == oldpressure)
			result += "More of the same";
		else
			result += "Watch out for cooler, rainy weather";
		wo.display(result);
	}

	public float getCurrentpressure() {
		return currentpressure;
	}

	public float getOldpressure() {
		return oldpressure;
	}
}
