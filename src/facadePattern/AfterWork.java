package facadePattern;

import facadePattern.computer.Computer;
import facadePattern.goHome.GoHome;
import facadePattern.sleep.Sleep;


public class AfterWork {
	public void afterWork() {
		GoHome facade = new GoHome();
		Computer computer = new Computer();
		Sleep Sleep = new Sleep();
		facade.goHomeIng();
		computer.startComputer();
		Sleep.goSleep();
	}

}
