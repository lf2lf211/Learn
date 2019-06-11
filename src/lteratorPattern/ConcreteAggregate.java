package lteratorPattern;

public class ConcreteAggregate implements Aggregate {

	private Object[] collection;
	// private Vector collection;
	private int last = 0;

	public ConcreteAggregate() {
		collection = new Object[3];
		// collection = new Vector(3);
	}

	public Object getItemAt(int index) {
		return collection[index];
		// return ((Object)collection.get(index));
	}

	public void appendItem(Object item) {
		this.collection[last] = item;
		last++;
		// collection.add(item);
	}

	public int getLength() {
		return last;
		// return collection.capacity();
	}

	/*
	 * 把遞增的架構放在 Aggregate 之外是 Iterator Pattern 的特徵之一。
	 * 利用這個特點可以對一個 ConcreteAggregate 建立出一個以上的 ConcreteIterator。
	 */
	@Override
	public Iterator iterator() {
		return new ConcreteIterator(this);
	}

}
