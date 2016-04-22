package hw.hw4;

import java.util.*;

public class ConsoleOutput implements WeatherOutput{

	public ConsoleOutput(Collection<WeatherDisplay> observers, String title) {
		for(WeatherDisplay wd : observers){
			wd.setOutputStrategy(this);
		}
	}
	public void display(String output){
		System.out.println(output);
	}

}
