package flyweightPattern;

import java.util.HashMap;

// http://c.biancheng.net/view/1371.html
// 享元（Flyweight）模式：運用共享技術來有效地支持大量細粒度對象的複用。

/*	優點：相同對像只要保存一份，這降低了系統中對象的數量，從而降低了系統中細粒度對像給內存帶來的壓力。

	缺點：
	1.為了使對象可以共享，需要將一些不能共享的狀態外部化，這將增加程序的複雜性。
	2.讀取享元模式的外部狀態會使得運行時間稍微變長。*/

/*	存在兩種狀態：
	內部狀態，即不會隨著環境的改變而改變的可共享部分；
	外部狀態，指隨環境改變而改變的不可以共享的部分。享元模式的實現要領就是區分應用中的這兩種狀態，並將外部狀態外部化。*/
/*	主要角色：
	抽象享元角色（Flyweight）:是所有的具體享元類的基類，為具體享元規範需要實現的公共接口，非享元的外部狀態以參數的形式通過方法傳入。
	具體享元（Concrete Flyweight）角色：實現抽象享元角色中所規定的接口。
	非享元（Unsharable Flyweight)角色：是不可以共享的外部狀態，它以參數的形式註入具體享元的相關方法中。
	享元工廠（Flyweight Factory）角色：負責創建和管理享元角色。當客戶對象請求一個享元對象時，享元工廠檢査系統中是否存在符合要求的享元對象，如果存在則提供給客戶；如果不存在的話，則創建一個新的享元對象。*/

public class FlyweightPattern {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight f01 = factory.getFlyweight("a");
		Flyweight f02 = factory.getFlyweight("a");
		Flyweight f03 = factory.getFlyweight("a");
		Flyweight f11 = factory.getFlyweight("b");
		Flyweight f12 = factory.getFlyweight("b");
		f01.operation(new UnsharedConcreteFlyweight("第1次調用a。"));
		f02.operation(new UnsharedConcreteFlyweight("第2次調用a。"));
		f03.operation(new UnsharedConcreteFlyweight("第3次調用a。"));
		f11.operation(new UnsharedConcreteFlyweight("第1次調用b。"));
		f12.operation(new UnsharedConcreteFlyweight("第2次調用b。"));
	}
}

//非享元角色
class UnsharedConcreteFlyweight {
	private String info;

	UnsharedConcreteFlyweight(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}

//抽象享元角色
interface Flyweight {
	public void operation(UnsharedConcreteFlyweight state);
}

//具體享元角色
class ConcreteFlyweight implements Flyweight {
	private String key;

	ConcreteFlyweight(String key) {
		this.key = key;
		System.out.println("具體享元" + key + "被創建！");
	}

	public void operation(UnsharedConcreteFlyweight outState) {
		System.out.print("具體享元" + key + "被調用，");
		System.out.println("非享元信息是:" + outState.getInfo());
	}
}

//享元工廠角色
class FlyweightFactory {
	private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

	public Flyweight getFlyweight(String key) {
		Flyweight flyweight = (Flyweight) flyweights.get(key);
		if (flyweight != null) {
			System.out.println("具體享元" + key + "已經存在，被成功獲取！");
		} else {
			flyweight = new ConcreteFlyweight(key);
			flyweights.put(key, flyweight);
		}
		return flyweight;
	}
}
