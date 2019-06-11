package designpattern.observerPattern;

public class Test {

	// https://dotblogs.com.tw/joysdw12/2013/03/13/96531
	// http://twmht.github.io/blog/posts/design-pattern/observer.html
	public static void main(String[] args) {

		/*
		 * 觀察者模式定義了物件之間的一對多關係，如此一來，當一個物件改變狀態，其他相依者都會收到通知並自動被更新-
		 */
		NewOffice office = new NewOffice(); // 建立一個新聞社(Subject)

		Reader john = new Reader("John"); // 建立一些讀者
		Reader mary = new Reader("Mary");
		Reader bill = new Reader("Bill");

		// 每個讀者訂閱新聞
		// Observer(Reader)訂閱Subject(NewOffice)
		office.registerObserver(john);
		office.registerObserver(mary);
		office.registerObserver(bill);

		// 發送新聞
		office.notifyObservers("New One...");

		System.out.println("----");
		office.removeObserver(john);
		office.notifyObservers("New Two...");

	}

}
