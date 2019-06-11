package mediatorPattern;

public class Client {
	// 中介者模式，又稱栛調者模式，直接照字面上解釋，就是有一個中介者負責處理事情。
	// 因為有一個中介者可以負責事情，如處理、傳遞、通知，就可以簡化物件之間的溝通和控制制方式，進而降低物件之間的耦合性(相依性，依賴性)。
	// 中介者模式定義一個可以封裝一組物件互動的物件，可以使物件不用直接互相引用而降低耦合性，且可以獨立改變物件之間的互動關係。
	public static void main(String[] args) {
		ApplicationMediator mediator = new ApplicationMediator();
		ConcreteColleague desktop = new ConcreteColleague(mediator);
		MobileColleague mobile = new MobileColleague(mediator);
		mediator.addColleague(desktop);
		mediator.addColleague(mobile);

		desktop.send("Hello World");
		mobile.send("Hello");

	}

}
