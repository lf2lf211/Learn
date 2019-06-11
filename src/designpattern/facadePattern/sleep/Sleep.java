package designpattern.facadePattern.sleep;

public class Sleep {
	public void goSleep() {
		CloseEye closeEye = new CloseEye();
		Lyingdown lyingdown = new Lyingdown();
		Walk walk = new Walk();
		walk.execute();
		lyingdown.execute();
		closeEye.execute();
	}

}
