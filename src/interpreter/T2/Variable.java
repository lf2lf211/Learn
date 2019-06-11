package interpreter.T2;

public class Variable implements Expression2 {
	@Override
	public int interpret(Context2 context) {
		return context.LookupValue(this);
	}
}