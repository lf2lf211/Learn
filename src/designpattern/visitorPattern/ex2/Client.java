package designpattern.visitorPattern.ex2;

public class Client {
	// 优点
	// 1、使得新增新的访问操作变得更加简单。
	// 2、能够使得用户在不修改现有类的层次结构下，定义该类层次结构的操作。
	// 3、将有关元素对象的访问行为集中到一个访问者对象中，而不是分散搞一个个的元素类中。
	//  缺点
	// 1、增加新的元素类很困难。在访问者模式中，每增加一个新的元素类都意味着要在抽象访问者角色中增加一个新的抽象操作，并在每一个具体访问者类中增加相应的具体操作，违背了“开闭原则”的要求。
	// 2、破坏封装。当采用访问者模式的时候，就会打破组合类的封装。
	// 3、比较难理解。貌似是最难的设计模式了。
	public static void main(String[] args) {
		Medicine a = new MedicineA("板蓝根", 11.0);
		Medicine b = new MedicineB("感康", 14.3);

		Presciption presciption = new Presciption();
		presciption.addMedicine(a);
		presciption.addMedicine(b);

		Visitor charger = new Charger();
		charger.setName("张三");

		Visitor workerOfPharmacy = new WorkerOfPharmacy();
		workerOfPharmacy.setName("李四");

		presciption.accept(charger);
		System.out.println("-------------------------------------");
		presciption.accept(workerOfPharmacy);
	}

}
