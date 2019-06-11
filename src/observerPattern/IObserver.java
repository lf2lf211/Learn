package observerPattern;

public interface IObserver {


	/**
	 * 給Subject(NewOffice)呼叫的方法
	 */
	void update(String pMessage);

}
