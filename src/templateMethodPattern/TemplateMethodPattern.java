package templateMethodPattern;

//http://c.biancheng.net/view/1376.html

//模板方法（Template Method）模式：定義一個操作中的算法骨架，將算法的一些步驟延遲到子類中，使得子類在可以不改變該算法結構的情況下重定義該算法的某些特定步驟。
/*	優點：
	1.它封裝了不變部分，擴展可變部分。它把認為是不變部分的算法封裝到父類中實現，而把可變部分算法由子類繼承實現，便於子類繼續擴展。
	2.它在父類中提取了公共的部分代碼，便於代碼復用。
	3.部分方法是由子類實現的，因此子類可以通過擴展方式增加相應的功能，符合開閉原則。

	缺點：
	1.對每個不同的實現都需要定義一個子類，這會導致類的個數增加，系統更加龐大，設計也更加抽象。
	2.父類中的抽象方法由子類實現，子類執行的結果會影響父類的結果，這導致一種反向的控制結構，它提高了代碼閱讀的難度。*/

/*	
	1.模板方法：定義了算法的骨架，按某種順序調用其包含的基本方法。
	2.基本方法：是整個算法中的一個步驟，包含以下幾種類型。
		(1)抽象方法：在抽像類中申明，由具體子類實現。
		(2)具體方法：在抽像類中已經實現，在具體子類中可以繼承或重寫它。
		(3)鉤子方法：在抽像類中已經實現，包括用於判斷的邏輯方法和需要子類重寫的空方法兩種。*/

public class TemplateMethodPattern {
	public static void main(String[] args) {
		AbstractClass tm = new ConcreteClass();
		tm.TemplateMethod();
	}
}

//抽像類
abstract class AbstractClass {
	public void TemplateMethod() // 模板方法
	{
		SpecificMethod();
		abstractMethod1();
		abstractMethod2();
		HookMethod1();
		if (HookMethod2()) {
			System.out.println("鉤子方法2被開啟...");
		} else {
			System.out.println("鉤子方法2被關閉...");
		}
	}

	public void SpecificMethod() // 具體方法
	{
		System.out.println("抽像類中的具體方法被調用...");
	}

	public abstract void abstractMethod1(); // 抽象方法1

	public abstract void abstractMethod2(); // 抽象方法2

	public void HookMethod1() { // 鉤子方法1
	}

	public boolean HookMethod2() // 鉤子方法2
	{
		return true;
	}
}

//具體子類
class ConcreteClass extends AbstractClass {
	public void abstractMethod1() {
		System.out.println("抽象方法1的實現被調用...");
	}

	public void abstractMethod2() {
		System.out.println("抽象方法2的實現被調用...");
	}

	public void HookMethod1() {
		System.out.println("鉤子方法1被重寫...");
	}

	public boolean HookMethod2() {
		return false;
	}
}
