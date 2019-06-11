package observerPattern;

public interface ISubject {

	/**
	 * 訂閱Observer(Reader)
	 */
	void registerObserver(IObserver reader);

	/**
	 * 取消訂閱Observer(Reader)
	 */
	void removeObserver(IObserver reader);

	/**
	 * 通知訂閱者Observer(Reader)
	 */
	void notifyObservers(String pContent);

}
