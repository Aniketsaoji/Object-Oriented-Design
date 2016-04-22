package hw.hw4;

public class StatisticsDisplay implements WeatherDisplay {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum = 0.0f;
	private int numReadings;
	private WeatherOutput wo;

	public StatisticsDisplay(WeatherData wd) {
		wd.registerObserver(this);
	}

	public void setOutputStrategy(WeatherOutput wo) {
		this.wo = wo;
	}

	public void update(WeatherData wd) {
		float temp = wd.getTemp();
		tempSum += temp;
		numReadings++;
		if (temp > maxTemp)
			maxTemp = temp;
		if (temp < minTemp)
			minTemp = temp;
		display();
	}

	public void display() {
		String result = "";
		result = "Avg/Max/Min temperature: " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp;
		wo.display(result);
	}

	public float getMaxTemp() {
		return maxTemp;
	}

	public float getMinTemp() {
		return minTemp;
	}

	public float getTempSum() {
		return tempSum;
	}

	public int getNumReadings() {
		return numReadings;
	}

}
