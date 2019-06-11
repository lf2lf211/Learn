package designpattern.facadePattern;

import designpattern.facadePattern.computer.Computer;
import designpattern.facadePattern.goHome.GoHome;
import designpattern.facadePattern.sleep.Sleep;


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
