package headFirstDesign.observer;

/**
 * @author houweitao
 * @date 2016年3月8日下午9:51:55
 */

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData data = new WeatherData();
		ConditionDisplay condition2 = new ConditionDisplay(data, "2");
		ConditionDisplay condition1 = new ConditionDisplay(data, "1");
		ConditionDisplay condition3 = new ConditionDisplay(data, "3");

		data.setStatus(32, 222, 333);
		data.removeObserver(condition1);
		data.setStatus(32, 222, 333);

	}
}
