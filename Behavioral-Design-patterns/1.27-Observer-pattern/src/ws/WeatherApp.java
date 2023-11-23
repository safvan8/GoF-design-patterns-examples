package ws;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
        LcdDisplay lcdDisplay = new LcdDisplay(weatherStation);

        // Simulate a change in temperature
        weatherStation.setTemperature(25);
        
        System.out.println("\n\n\n");
        
        // Simulate a change in temperature
        weatherStation.setTemperature(30);

    }
}
