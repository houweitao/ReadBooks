package headFirstDesign.observer.interfaces;

/**
 * @author houweitao
 * @date 2016年3月8日下午9:29:14
 */

public interface Subject {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObservers();
}
