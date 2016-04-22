package hw.hw4;

import java.util.*;

// The WeatherData constructor has two arguments:
// its city, and a reference to the WeatherMgr object.
// The constructor is responsible for registering itself
// as an observer of the WeatherMgr object.

// WeatherData objects are observers of the WeatherMgr object

// The WeatherData constructor has two arguments:
// its city, and a reference to the WeatherMgr object.
// The constructor is responsible for registering
// itself as an observer of the WeatherMgr object.

public class WeatherData {
	private Collection<WeatherDisplay> observers = new ArrayList<WeatherDisplay>();
	private float temperature;
	private float humidity;
	private float pressure;
	private String city;
	

	public WeatherData(String city, WeatherMgr ref) {
		this.city = city;
		ref.registerObserver(this);
	}

	// WeatherDisplay observers using pull (need getters, pass itself)
	public void registerObserver(WeatherDisplay obs) {
		observers.add(obs);
	}

	public void notifyObservers() {
		for (WeatherDisplay wd : observers)
			wd.update(this);
	}

	public float getTemp() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(String city, float temperature, float humidity, float pressure) {
		if(city.equals(this.city)){
			this.temperature = temperature;
			this.humidity = humidity;
			this.pressure = pressure;
			measurementsChanged();
		}
	}
}
