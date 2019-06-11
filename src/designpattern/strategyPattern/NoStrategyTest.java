package designpattern.strategyPattern;

public class NoStrategyTest {

	public static void main(String[] args) {
		
		NoStrategyMan noStrategyMan = new NoStrategyMan();

		//進行A策略
		noStrategyMan.doSomething("A");
		
		//進行B策略
		noStrategyMan.doSomething("B");
		
		//進行C策略
		noStrategyMan.doSomething("C");
	}	
	
}
