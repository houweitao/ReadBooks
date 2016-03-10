package headFirstDesign.observer;

import headFirstDesign.observer.interfaces.DisplayElement;
import headFirstDesign.observer.interfaces.Observer;
import headFirstDesign.observer.interfaces.Subject;

/**
 * @author houweitao
 * @date 2016年3月8日下午9:44:26
 */

public class ConditionDisplay implements Observer, DisplayElement {
	private String name;
	private float temperrature;
	private float humidity;
	private float pressure;
	private Subject weatherData;

	@Override
	public boolean equals(Object obj) {
		ConditionDisplay cur = (ConditionDisplay) obj;
		return name.equals(cur.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConditionDisplay(Subject data, String name) {
		this.weatherData = data;
		weatherData.registerObserver(this);
		this.name = name;
	}

	public Subject getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(WeatherData weatherData) {
		this.weatherData = weatherData;
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

	public void display() {
		// TODO Auto-generated method stub
		System.out.println(name + " condition: " + temperrature + " F degrees " + humidity + " .." + pressure);
	}

	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperrature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
