package designpattern.visitorPattern.ex1;

abstract class Element {
	public abstract void accept(IVisitor visitor);

	public abstract void doSomething();
}
