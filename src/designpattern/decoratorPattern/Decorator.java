package designpattern.decoratorPattern;

								//實做Component
public abstract class Decorator implements Component {

	private String decoration;
	private Component component;
	
	public Decorator(String decoration, Component component) {
		this.decoration = decoration;
		this.component = component;
	}
	
	//回傳裝飾過的name
	@Override
	public String getName() {
		return component.getName() + decoration;
	}
	
	//顯示裝飾過的敘述
	@Override
	public void showName() {
		System.out.println("This is a Component:\""+ component.getName() +"\"" + decoration);
		//多呼叫了新方法
		this.newMethod();
	}
	
	//Decorator新添加的方法
	public void newMethod() {
		//傳入的為Component介面類型，需先轉型為Decorator類才可呼叫此方法
		if(component instanceof Decorator) {
			Decorator decorator = (Decorator) component;
			decorator.newMethod();
		}
	}
}
