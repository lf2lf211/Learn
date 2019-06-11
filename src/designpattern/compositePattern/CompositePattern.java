package designpattern.compositePattern;

import java.util.ArrayList;

// http://c.biancheng.net/view/1373.html
// 組合（Composite）模式：將對象組合成樹狀層次結構，使用戶對單個對象和組合對象具有一致的訪問性。(部分-整體模式)
/*	優點：
	1.組合模式使得客戶端代碼可以一致地處理單個對象和組合對象，無須關心自己處理的是單個對象，還是組合對象，這簡化了客戶端代碼；
	2.更容易在組合體內加入新的對象，客戶端不會因為加入了新的對象而更改源代碼，滿足“開閉原則”；

	缺點：
	1.設計較複雜，客戶端需要花更多時間理清類之間的層次關係；
	2.不容易限制容器中的構件；
	3.不容易用繼承的方法來增加構件的新功能；*/

/*主要角色：
	抽象構件（Component）角色：它的主要作用是為樹葉構件和樹枝構件聲明公共接口，並實現它們的默認行為。在透明式的組合模式中抽象構件還聲明訪問和管理子類的接口；在安全式的組合模式中不聲明訪問和管理子類的接口，管理工作由樹枝構件完成。
	樹葉構件（Leaf）角色：是組合中的葉節點對象，它沒有子節點，用於實現抽象構件角色中聲明的公共接口。
	樹枝構件（Composite）角色：是組合中的分支節點對象，它有子節點。它實現了抽象構件角色中聲明的接口，它的主要作用是存儲和管理子部件，通常包含Add()、Remove()、GetChild() 等方法。*/

/*應用時機：
	在需要表示一個對象整體與部分的層次結構的場合。
	要求對用戶隱藏組合對象與單個對象的不同，用戶可以用統一的接口使用組合結構中的所有對象的場合。*/


/*透明模式*/ //優：客戶端無須區別樹葉對象和樹枝對象；缺：樹葉構件本來沒有Add()、Remove()及GetChild()方法，卻要實現它們（空實現或拋異常），這樣會帶來一些安全性問題

//抽象構件
interface Component {
	public void add(Component c);

	public void remove(Component c);

	public Component getChild(int i);

	public void operation();
}

//樹葉構件
class Leaf implements Component {
	private String name;

	public Leaf(String name) {
		this.name = name;
	}

	public void add(Component c) {
	}

	public void remove(Component c) {
	}

	public Component getChild(int i) {
		return null;
	}

	public void operation() {
		System.out.println("樹葉" + name + "：被訪問！");
	}
}

//樹枝構件
class Composite implements Component {
	private ArrayList<Component> children = new ArrayList<Component>();

	public void add(Component c) {
		children.add(c);
	}

	public void remove(Component c) {
		children.remove(c);
	}

	public Component getChild(int i) {
		return children.get(i);
	}

	public void operation() {
		for (Object obj : children) {
			((Component) obj).operation();
		}
	}
}

public class CompositePattern {
	public static void main(String[] args) {
		Component c0 = new Composite();
		Component c1 = new Composite();
		Component leaf1 = new Leaf("1");
		Component leaf2 = new Leaf("2");
		Component leaf3 = new Leaf("3");
		c0.add(leaf1);
		c0.add(c1);
		c1.add(leaf2);
		c1.add(leaf3);
		c0.operation();
	}
}
