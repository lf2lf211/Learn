package lteratorPattern;

public class ConcreteAggregate_P {
	
	private Person[] namecollection;
	private int last = 0;

	public ConcreteAggregate_P(int maxsize) {
		this.namecollection = new Person[maxsize];
	}

	public Person getPersonAt(int index) {
		return namecollection[index];
	}

	public void appendPerson(Person personName) {
		this.namecollection[last] = personName;
		last++;
	}

	public int getLength() {
		return last;
	}
}