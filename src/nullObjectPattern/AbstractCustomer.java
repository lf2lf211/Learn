package nullObjectPattern;

/**
 * 1. 创建一个抽象类
 */
public abstract class AbstractCustomer {
	protected String name;

	public abstract boolean isNil();

	public abstract String getName();
}
