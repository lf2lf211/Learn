package singletonPattern;

public class SingletonTest {

	public static void main(String[] args) {
		
		//用new的方式取得
		Singleton notSingle0 = new Singleton();
		notSingle0.printCount();
		
		Singleton notSingle1 = new Singleton();
		notSingle1.printCount();
		
		Singleton notSingle2 = new Singleton();
		notSingle2.printCount();
		
		System.out.println("--------------------------");
		//用getInstance的方式取得
		Singleton singleton0 = Singleton.getInstance();
		singleton0.printCount();
		
		Singleton singleton1 = Singleton.getInstance();
		singleton1.printCount();
		
		Singleton singleton2 = Singleton.getInstance();
		singleton2.printCount();
		
	}

}
