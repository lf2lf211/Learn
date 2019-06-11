package designpattern.prototypePattern;

/* http://c.biancheng.net/view/1343.html
	原型（Prototype）模式：將一個對像作為原型，通過對其進行複製而克隆出多個和原型類似的新實例。*/
/* https://ithelp.ithome.com.tw/articles/10205989
	使用時機：
	類別初始化需要消耗非常多的資源時（資料、硬體資源）。
	創造複雜的物件或是類別初始化需要很繁瑣的準備或存取權限。
	當一個物件需要提供給許多其他物件存取，而且其他物件會需要修改到前者裡面的數值時。*/
/* https://blog.csdn.net/xlgen157387/article/details/47337681
	(1) 淺克隆（shallow clone），淺拷貝是指拷貝對象時僅僅拷貝對象本身和對像中的基本變量，而不拷貝對象包含的引用指向的對象。
		(Object的clone()為淺克隆) 
	(2) 深克隆（deep clone），深拷貝不僅拷貝對象本身，而且拷貝對象包含的引用指向的所有對象。*/

//具體原型類 //Cloneable為抽象原型類
class Realizetype implements Cloneable {
	private String name;
	
	Realizetype(String name) {
		System.out.println("具體原型創建成功！");
		this.name = name;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		System.out.println("具體原型複製成功！");
		return (Realizetype) super.clone();
	}
	
	public void showName() {
		System.out.println("這是" + name + "！");
	}
}

//原型模式的測試類
public class PrototypeTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Realizetype obj1 = new Realizetype("AAA");
		Realizetype obj2 = (Realizetype) obj1.clone();
		obj1.showName();
		obj2.showName();
		System.out.println("obj1 == obj2 ? " + (obj1 == obj2) + "！");
	}
}