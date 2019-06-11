package nullObjectPattern;

/**
 * 2. 创建扩展了AbstractCustomer类的实体类。
 */
public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		this.name = name;
	}

	@Override
	public boolean isNil() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}
}
