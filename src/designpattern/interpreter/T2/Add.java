package designpattern.interpreter.T2;

//非终结符表达式(Nonterminal Expression)
public class Add implements Expression2 {
	private Expression2 left, right;

	public Add(Expression2 left, Expression2 right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret(Context2 context) {
		return left.interpret(context) + right.interpret(context);
	}
}
