package lteratorPattern;

public class IteratorExample {

	// http://www.dotspace.idv.tw/Jyemii/patternscolumn/articles/IteratorForJava.htm
	// http://twmht.github.io/blog/posts/design-pattern/iterator.html
	public static void main(String[] args) {
		
		/*
		 * 不管聚合物件的內部結構是什麼 ConcreteIterator 類別不須更改，仍可存取物件；
		 * 利用遺傳方式可增加多種巡訪聚合物件的方式；聚合物件改變時（如 Array 改成 Vector）ConcreteIterator 類別仍可用相同的介面來巡訪聚合物件。
		 */
		ConcreteAggregate collection = new ConcreteAggregate();
		collection.appendItem(new Person("Davis"));
		collection.appendItem(new Person("Frank"));
		collection.appendItem(new Person("Jeny"));
		Iterator it = collection.iterator();
		while (it.hasNext()) {
			Person person = (Person) it.next();
			System.out.println("" + person.getName());
		}
	}

}
