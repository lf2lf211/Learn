package decoratorPattern;

public class ComponentImpl implements Component {

	private String name;
	
	public ComponentImpl(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void showName() {
		System.out.println("This is a Component:\""+ name +"\"");
	}

}
