package hw.hw4;

public class CurrentConditionsDisplay implements WeatherDisplay {
	private float temp;
	private float humidity;
	private WeatherOutput wo;

	public CurrentConditionsDisplay(WeatherData wd) {
		wd.registerObserver(this);
	}

	public void setOutputStrategy(WeatherOutput wo) {
		this.wo = wo;
	}

	public void update(WeatherData wd) {
		this.temp = wd.getTemp();
		this.humidity = wd.getHumidity();
		display();
	}

	public void display() {
		String result = "";
		result = "Current conditions: " + temp + "F degrees and " + humidity + "% humidity";
		wo.display(result);
	}

	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

}
