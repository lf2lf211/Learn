package compositePattern;

import java.util.ArrayList;

/*安全模式*/ //優：避免安全性問題；缺：葉子和分支有不同的接口，客戶端在調用時要知道樹葉對象和樹枝對象的存在，所以失去了透明性。

//抽象構件
interface ComponentSave {

	public void operation();
}

//樹葉構件
class LeafSave implements ComponentSave {
	private String name;

	public LeafSave(String name) {
		this.name = name;
	}

	public void operation() {
		System.out.println("樹葉" + name + "：被訪問！");
	}
}

//樹枝構件
class CompositeSave implements ComponentSave {
	private ArrayList<ComponentSave> children = new ArrayList<ComponentSave>();

	public void add(ComponentSave c) {
		children.add(c);
	}

	public void remove(ComponentSave c) {
		children.remove(c);
	}

	public ComponentSave getChild(int i) {
		return children.get(i);
	}

	public void operation() {
		for (Object obj : children) {
			((Component) obj).operation();
		}
	}
}

public class CompositePatternSafe {
	public static void main(String[] args) {
		CompositeSave c0 = new CompositeSave();
		CompositeSave c1 = new CompositeSave();
		LeafSave leaf1 = new LeafSave("1");
		LeafSave leaf2 = new LeafSave("2");
		LeafSave leaf3 = new LeafSave("3");
		c0.add(leaf1);
		c0.add(c1);
		c1.add(leaf2);
		c1.add(leaf3);
		c0.operation();
	}
}
