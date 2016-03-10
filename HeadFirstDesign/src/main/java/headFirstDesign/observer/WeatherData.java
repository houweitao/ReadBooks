package headFirstDesign.observer;

import java.util.ArrayList;

import headFirstDesign.observer.interfaces.Observer;
import headFirstDesign.observer.interfaces.Subject;

/**
 * @author houweitao
 * @date 2016年3月8日下午9:33:48
 */

public class WeatherData implements Subject {

	private ArrayList<Observer> observers;
	private float temperrature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		// TODO Auto-generated constructor stub
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer o : observers) {
			o.update(temperrature, humidity, pressure);
		}
	}

	public void setStatus(float temp, float hum, float pre) {
		this.temperrature = temp;
		this.humidity = hum;
		this.pressure = pre;

		notifyObservers();
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public float getTemperrature() {
		return temperrature;
	}

	public void setTemperrature(float temperrature) {
		this.temperrature = temperrature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
	
}
