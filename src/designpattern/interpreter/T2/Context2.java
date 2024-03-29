package designpattern.interpreter.T2;

import java.util.HashMap;
import java.util.Map;


//环境(Context)角色
public class Context2 {
	private Map valueMap = new HashMap<>();

	public void addValue(Variable x, int y) {
		valueMap.put(x, y);
	}

	public int LookupValue(Variable x) {
		return (int) valueMap.get(x);
	}
}