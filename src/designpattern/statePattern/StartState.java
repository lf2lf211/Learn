package designpattern.statePattern;

public class StartState extends State {

	@Override
	public String GetState(Context context) {
		if (context.getAction().equals("申請")) {
			context.setAction("負責人");
			return "工作單申請";
		} else {
			context.setState(new OwnerState());
			return context.GetState();
		}

	}

}
