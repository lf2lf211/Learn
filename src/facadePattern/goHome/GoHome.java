package facadePattern.goHome;

public class GoHome {
	public void goHomeIng() {

		OpenDoor openDoor = new OpenDoor();
		CloseDoor closeDoor = new CloseDoor();
		Walk walk = new Walk();
		openDoor.execute();
		walk.execute();
		closeDoor.execute();

	}

}
