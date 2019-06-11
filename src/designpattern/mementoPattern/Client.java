package designpattern.mementoPattern;

public class Client {

	// 定义：在不破坏封闭的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。

	// 優點
	// 1、发起人备份自己的状态不需要自己管理，可以备份到外部，这样可以很好的保持封装的边界，这样做的意义在于可以给外部提供一个简单的操作该对象内部状态的接口。保持封装的边界这应该算是最重要的优点了。
	// 2、发起人状态的备份与恢复，发起人自身不需要管理与操作，而是由客户端自行按需要处理。
	// 3、如果发起人的状态出现问题，可以很轻松的恢复。

	// 缺點
	// 1、如果全部备份发起人的状态，或者其中有占用内存较大的属性（比如一个长数组），则会让备忘录模式的使用代价昂贵。
	// 2、由于备份的信息是由发起人自己提供的，所以管理者无法预知备份的信息的大小，所以在客户端使用时，可能一个操作占用了很大的内存，但客户端并不知晓。
	// 3、当发起人的状态改变的时候，有可能这个状态无效。如果状态改变的成功率不高的话，可以采取“假如”协议模式。“假如”的意思是指，我们将一直假如状态的改变会失败，从而对此做出一系列准备的工作。不过很明显，如果状态改变的成功率很高，则这样做的收益甚微。

	// 备忘录模式使用三个类 Memento、Originator 和 CareTaker。
	// 一个便是发起人（Originator）:Person.java，它不仅有自己的状态，而且还负责创建一个备忘录（Memento）:Lyingdown.java以及使用备忘录恢复自己的状态，而备忘录则记录了发起人的状态
	// 最后一个角色管理者（Caretaker）: Soul.java，则是用来管理备忘录的。
	public static void main(String[] args) {
		Soul soul = new Soul();
		Person personA = new Person("工程師A");
		Person personB = new Person("工程師B");
		// 工程師A的记忆
		personA.addStory("早上吃薯餅");
		personA.addStory("中午吃便當");

		// 工程師B的记忆
		personB.addStory("早上吃滷肉飯");
		personB.addStory("午餐吃土");

		System.out.println(personA);
		System.out.println(personB);
		System.out.println("-----------------------------------------------------------");

		soul.pullAwayMemory(personA);
		soul.pullAwayMemory(personB);

		personA.addStory("看到一個人在飛");
		personB.addStory("看到一個人在飛");

		System.out.println(personA);
		System.out.println(personB);
		System.out.println("-----------------------------------------------------------");

		// 强行恢复记忆
		soul.forceFixMemory(personA);
		soul.forceFixMemory(personB);

		System.out.println(personA);
		System.out.println(personB);
		System.out.println("-----------------------------------------------------------");

	}
}