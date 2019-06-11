package designpattern.strategyPattern;

public class StrategyTest {
	public static void main(String[] args) {
		
		StrategyMan strategyMan = new StrategyMan();
		
		//進行A策略
		strategyMan.doSomething(new StrategyA());
		
		//進行B策略
		strategyMan.doSomething(new StrategyB());
		
		//進行C策略
		strategyMan.doSomething(new StrategyC());
		
	}
}
