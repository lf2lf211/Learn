package designpattern.adaptorPattern;

/*對象適配器模式*///可釆用將現有組件庫中已經實現的組件引入適配器類中，該類同時實現當前系統的業務接口。

//對象適配器類
class ObjectAdapter implements Target {
	
	private Adaptee adaptee;

	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	public void request() {
		adaptee.specificRequest();
	}
}

//客戶端代碼
public class ObjectAdapterTest {
	public static void main(String[] args) {
		
		System.out.println("對象適配器模式測試：");
		Adaptee adaptee = new Adaptee();
		Target target = new ObjectAdapter(adaptee);
		target.request();
	}
}
