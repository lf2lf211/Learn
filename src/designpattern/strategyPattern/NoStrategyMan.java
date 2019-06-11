package designpattern.strategyPattern;

public class NoStrategyMan {
	NoStrategy noStrategy = new NoStrategy();
	
	public void doSomething(String strategy) {
		switch(strategy) {
		case "A":
			noStrategy.doStrategy("A");
			break;
		case "B":
			noStrategy.doStrategy("B");
			break;
		default:
			System.out.println("Faild!");
			break;				
		}
	}
	
}
