package visitorPattern.ex1;

interface IVisitor {
	public void visit(ConcreteElement1 el1);

	public void visit(ConcreteElement2 el2);
}
