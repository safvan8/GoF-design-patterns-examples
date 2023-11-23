package ws;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface IObserver {
	void update();
}

// Observable Interface
interface IObservable {
	void addObserver(IObserver observer);

	void removeObserver(IObserver observer);

	void notifyObservers();
}

// WeatherStation class implementing IObservable
class WeatherStation implements IObservable {
	private List<IObserver> observerList;
	private int temperature;

	public WeatherStation() {
		this.observerList = new ArrayList<>();
	}

	public void addObserver(IObserver observer) {
		this.observerList.add(observer);
	}

	public void removeObserver(IObserver observer) {
		this.observerList.remove(observer);
	}

	public void notifyObservers() {
		for (IObserver observer : observerList) {
			observer.update();
		}
	}

	public int getTemperature() {
		return temperature;
	}

	// Assume this method is used to set the temperature
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyObservers(); // Notify observers when temperature changes
	}
}

//implement this Interface for making class as a Display ( this interface is Optional ) 
interface IDisplay {
	public void displayInfo();
}

// PhoneDisplay class implementing IObserver
class PhoneDisplay implements IObserver, IDisplay {
	private WeatherStation station;

	private Integer temperature;

	public PhoneDisplay(WeatherStation station) {
		this.station = station;
		this.station.addObserver(this); // Register PhoneDisplay as an observer
	}

	public void update() {
		temperature = station.getTemperature();
		// Consume temperature data as needed
		displayInfo();
	}

	public void displayInfo() {
		// Code to display weather information to end user on the phone
		System.out.println("{{{{ Display in Phone : Temp is : " + temperature + "}}}}");

	}
}

// LcdDisplay class implementing IObserver
class LcdDisplay implements IObserver, IDisplay {
	private WeatherStation station;

	private Integer temperature;

	public LcdDisplay(WeatherStation station) {
		this.station = station;
		this.station.addObserver(this); // Register LcdDisplay as an observer
	}

	public void update() {
		temperature = station.getTemperature();
		// Consume temperature data as needed
		displayInfo();
	}

	public void displayInfo() {
		// Code to display weather information to end user on the LCD display
		System.out.println("{{{{ Display in LCD : Temp is : " + temperature + "}}}}");
	}
}
