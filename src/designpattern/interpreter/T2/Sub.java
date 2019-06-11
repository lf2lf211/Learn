package designpattern.interpreter.T2;

public class Sub implements Expression2 {
	private Expression2 left, right;

	public Sub(Expression2 left, Expression2 right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret(Context2 context) {
		return left.interpret(context) - right.interpret(context);
	}
}
