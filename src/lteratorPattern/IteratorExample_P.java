package lteratorPattern;

public class IteratorExample_P {
	
	public static void main(String[] args) {
		
		/*
		 * 僅Person, ConcreteAggregate_P, 無抽象層。
		 * 
		 * ConcreteAggregate 類別跟 Person 類別綁在一起，如果要換成其他類別的話，ConcreteAggregate 類別勢必要重寫，
		 * 如果 ConcreteAggregate 類別裡的 Person[] namecollection，想換成 Vector 或 List 的話，
		 * 那此 IteratorExample 類別的巡訪方式也要重寫，所以程式碼顯得沒有彈性，無法再利用。
		*/
		ConcreteAggregate_P namecollection = new ConcreteAggregate_P(3);
		Person person;
		namecollection.appendPerson(new Person("Davis"));
		namecollection.appendPerson(new Person("Frank"));
		namecollection.appendPerson(new Person("Jeny"));
		for (int i = 0; i < namecollection.getLength(); i++) {
			person = namecollection.getPersonAt(i);
			System.out.println("" + person.getName());
		}
		
	}
	
}
