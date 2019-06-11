package designpattern.interpreter.T2;

// 终结符表达式(Terminal Expression)
public class Constant implements Expression2 {
	private int i;

	public Constant(int i) {
		this.i = i;
	}

	@Override
	public int interpret(Context2 context) {
		return i;
	}
}
