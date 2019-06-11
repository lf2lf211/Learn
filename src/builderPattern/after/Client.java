package builderPattern.after;

public class Client {
	// 更詳細介紹 :http://www.cnblogs.com/zuoxiaolong/p/pattern16.html

	// 定义：将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
	// 需要构建一批构建过程相同但表示不同的产品，而构建过程非常复杂

	// 有著四種腳色,首先是建造者接口(Builder):DoppelgangerBuilder.java
	// 和具体的建造者(ConcreteBuilder):FatBuilder.java,ThinBuilder.java
	// 而指挥者(Director):Soul.java，和產品(Product):Doppelganger.java
	public static void main(String[] args) {
		Soul soul = new Soul();
		// 制造一个瘦小的代打工程師1
		System.out.println("获得了" + soul.createDoppelganger(new ThinBuilder(), "代打工程師1"));
		System.out.println("----------------------------------------");

		// 制造一个胖胖的代打工程師2
		System.out.println("获得了" + soul.createDoppelganger(new FatBuilder(), "代打工程師2"));
		System.out.println("----------------------------------------");

		// 制造一个胖胖的代打工程師3
		System.out.println("获得了" + soul.createDoppelganger(new FatBuilder(), "代打工程師3"));

		System.out.println("----------------------------------------");

		System.out.println("获得了" + soul.createDoppelganger(new FatBuilder(), "代打工程師3"));
	}
}