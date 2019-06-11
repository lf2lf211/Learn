package lteratorPattern;

public class ConcreteIterator implements Iterator {

	private ConcreteAggregate namecollection;
	private int index;

	public ConcreteIterator(ConcreteAggregate collection) {
		this.namecollection = collection;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		if (index < namecollection.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Object item = namecollection.getItemAt(index);
		index++;
		return item;
	}

}
