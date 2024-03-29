package designpattern.visitorPattern.ex2;

//抽象访问者：
public abstract class Visitor {
	protected String name;

	public void setName(String name) {
		this.name = name;
	}

	public abstract void visitor(MedicineA a);

	public abstract void visitor(MedicineB b);

}
