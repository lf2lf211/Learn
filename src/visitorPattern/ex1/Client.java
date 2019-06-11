package visitorPattern.ex1;

import java.util.List;


public class Client {
	// 主要将数据结构与数据操作分离。
	// 访问者模式的优点
	//
	// 所以当发生变化时，可以在不改变元素类本身的前提下，实现对变化部分的扩展。扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
	// 訪問者模式 使用頻率不高，在大部分的狀況之下不需要使用這個模式。在資料結構穩定(甚至固定)時才適合使用，如果任意使用反而會造成(資料結構)擴充困難的結果。

	// 抽象访问者(Visitor接口)：抽象类或者接口，声明访问者可以访问哪些元素，具体到程序中就是visit方法中的参数定义哪些对象是可以被访问的。
	// 访问者(ConcreteVisitor)：实现抽象访问者所声明的方法，它影响到访问者访问到一个类后该干什么，要做什么事情。
	// 抽象元素类(Element接口)：接口或者抽象类，声明接受哪一类访问者访问，程序上是通过accept方法中的参数来定义的。抽象元素一般有两类方法，一部分是本身的业务逻辑，另外就是允许接收哪类访问者来访问。
	// 元素类(ConcreteElement)：实现抽象元素类所声明的accept方法，通常都是visitor.visit(this)，基本上已经形成一种定式了。
	// 结构对象(ObjectStructure)：一个元素的容器，一般包含一个容纳多个不同类、不同接口的容器，如List、Set、Map等，在项目中一般很少抽象出这个角色。
	public static void main(String[] args) {

		List<Element> list = ObjectStruture.getList();
		for (Element e : list) {
			e.accept(new Visitor());
		}
	}

}
