package hw.hw4;

import javax.swing.JOptionPane;

public class ConsoleInput implements WeatherInput{
	private String city;
	private float temperature;
	private float humidity;
	private float pressure;
	private WeatherMgr mgr;
	
	public ConsoleInput(WeatherMgr mgr){
		this.mgr = mgr;
	}
	
	public void run(){
		String City = JOptionPane.showInputDialog("Enter the desired city (with the proper capitalization)");
        String[] Cities = City.split(" ");
        String thecity = Cities[0];
        this.city = thecity;
        
        String temp = JOptionPane.showInputDialog("Enter the temperature");
        String[] temps = temp.split(" ");
        String thetemp = temps[0];
        float temperature = Float.parseFloat(thetemp);
        this.temperature = temperature;
        
        String humidity = JOptionPane.showInputDialog("Enter the humidity");
        String[] humidities = humidity.split(" ");
        String thehumidity = humidities[0];
        float floathumidity = Float.parseFloat(thehumidity);
        this.humidity = floathumidity;
        
        String pressure = JOptionPane.showInputDialog("Enter the pressure");
        String[] pressures = pressure.split(" ");
        String thepressure = pressures[0];
        float floatpressure = Float.parseFloat(thepressure);
        this.pressure = floatpressure;
        
//        Testing
//        System.out.println(this.city);
//        System.out.println(this.temperature);
//        System.out.println(this.humidity);
//        System.out.println(this.pressure);
        
        mgr.update(this.city, this.temperature, this.humidity, this.pressure);
	}

}
