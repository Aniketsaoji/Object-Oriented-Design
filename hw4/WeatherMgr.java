package hw.hw4;

import java.util.ArrayList;
import java.util.Collection;

// The WeatherMgr object will then send the measurement data to its WeatherData objects

public class WeatherMgr {
	private Collection<WeatherData> observers = new ArrayList<WeatherData>();
	
	
	//WeahterData observers using push
	public void registerObserver(WeatherData obs) {
		observers.add(obs);
	}
	
	public void update(String city, float temperature, float humidity, float pressure){
		for(WeatherData wd : observers){
			wd.setMeasurements(city, temperature, humidity, pressure);
		}
	}

}
