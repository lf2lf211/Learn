package ceationalPatterns.adaptorPattern;

//http://c.biancheng.net/view/1361.html
//適配器(轉接器)（Adapter）模式：將一個類的接口轉換成客戶希望的另外一個接口，使得原本由於接口不兼容而不能一起工作的那些類能一起工作。
/*	優點：
	1.客戶端通過適配器可以透明地調用目標接口。
	2.復用了現存的類，程序員不需要修改原有代碼而重用現有的適配者類。
	3.將目標類和適配者類解耦，解決了目標類和適配者類接口不一致的問題。

	缺點：
	對類適配器來說，更換適配器的實現過程比較複雜。*/

/*	目標（Target）接口：當前系統業務所期待的接口，它可以是抽像類或接口。
	適配者（Adaptee）類：它是被訪問和適配的現存組件庫中的組件接口。
	適配器（Adapter）類：它是一個轉換器，通過繼承或引用適配者的對象，把適配者接口轉換成目標接口，讓客戶按目標接口的格式訪問適配者。*/

/*類適配器模式*///可以定義一個適配器類來實現當前系統的業務接口，同時又繼承現有組件庫中已經存在的組件。

//目標接口
interface Target {
	public void request();
}

//適配者接口
class Adaptee {
	public void specificRequest() {
		System.out.println("適配者中的業務代碼被調用！");
	}
}

//類適配器類
class ClassAdapter extends Adaptee implements Target {
	public void request() {
		specificRequest();
	}
}

//客戶端代碼
public class ClassAdapterTest {
	public static void main(String[] args) {
		System.out.println("類適配器模式測試：");
		Target target = new ClassAdapter();
		target.request();
	}
}
