package hw.hw4;

// Your WeatherDisplay classes should generate the message
// string, and then call an output class to do the printing.

// Each WeatherDisplay constructor has one argument: its
// associated WeatherData object. The constructor is
// responsible for registering itself as an observer of the data object.

public interface WeatherDisplay {
   public void update(WeatherData wd);
   public void setOutputStrategy(WeatherOutput wo);
   public void display();
}

