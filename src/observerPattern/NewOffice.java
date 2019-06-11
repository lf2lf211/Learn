package observerPattern;

import java.util.ArrayList;

public class NewOffice implements ISubject {

	private ArrayList<IObserver> readerList = new ArrayList<IObserver>(); // 紀錄已註冊的Readers

	// 如須唯一可設為單例
//	private NewOffice() {
//		
//	}
	
	
	/**
	 * 註冊觀察者Reader
	 */
	@Override
	public void registerObserver(IObserver reader) {
		readerList.add(reader);
		System.out.println(reader.toString() + " is register.");
	}

	/**
	 * 取消註冊觀察者Reader
	 */
	@Override
	public void removeObserver(IObserver reader) {
		readerList.remove(reader);
		System.out.println(reader.toString() + " is removed.");
	}

	/**
	 * 通知全部的Reader
	 */
	@Override
	public void notifyObservers(String pContent) {
		for (IObserver reader : readerList) {
			reader.update(pContent);
		}
	}


}
