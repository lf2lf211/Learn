package decoratorPattern;

public class DecoratorHeir extends Decorator{

	public DecoratorHeir(Component component) {
		super(" with Decoration!", component);
	}
	
	@Override
	public void newMethod() {
		System.out.println("使用了Decorator的新方法!");
	}

}
