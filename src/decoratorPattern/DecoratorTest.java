package decoratorPattern;

public class DecoratorTest {

	public static void main(String[] args) {
		
		Component component = new ComponentImpl("名字");
		
		component.showName();
		
		System.out.println("------------------------------------");
		//將component放入decorator中
		Component decorator = new DecoratorHeir(component);
		
		decorator.showName();
	}

}
