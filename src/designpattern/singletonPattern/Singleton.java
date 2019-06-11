package designpattern.singletonPattern;


public class Singleton {
	
	public static Singleton instance = null;
	
	public int count;
	
	//可將建構子設為private，使使用者無法用new取得實體
//	private Singleton() {
//		
//	}
	
	public static Singleton getInstance() {
		
		//沒有則new一個新的，有則沿用
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
	
	public void printCount() {
		System.out.println("now Count is: " + count);
		count++;
	}
}
