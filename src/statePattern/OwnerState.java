package statePattern;

public class OwnerState extends State {

	@Override
	public String GetState(Context context) {
		if (context.getAction().equals("負責人")) {
			context.setAction("使用者");
			return "負責人處理中";
		} else {
			context.setState(new UserState());
			return context.GetState();
		}

	}
}