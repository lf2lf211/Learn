package observerPattern;

public class Reader implements IObserver {

	private String name = null;   // 讀者的名稱

	public Reader(String name) {
		this.name = name;
	}


	/**
	 * Observer(NewsOffice)的更新通知
	 */
	@Override
	public void update(String pMessage) {
		read(pMessage); // 當Reader被News通知時會執行read()
	}

	private void read(String pMessage) {
		System.out.println(name + " recieve : " + pMessage);
	}
	
	@Override
	public String toString() {
		return name;
	}

}
