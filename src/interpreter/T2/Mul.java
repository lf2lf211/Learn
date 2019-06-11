package interpreter.T2;

public class Mul implements Expression2 {
	private Expression2 left, right;

	public Mul(Expression2 left, Expression2 right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret(Context2 context) {
		return left.interpret(context) * right.interpret(context);
	}
}