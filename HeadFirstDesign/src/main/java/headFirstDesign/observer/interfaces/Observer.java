package headFirstDesign.observer.interfaces;

/**
 * @author houweitao
 * @date 2016年3月8日下午9:30:21
 */

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
