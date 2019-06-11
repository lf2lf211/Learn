package statePattern;

public class UserState extends State {

	@Override
	public String GetState(Context context) {
		if (context.getAction().equals("使用者")) {
			context.setAction("結束");
			return "使用者確認中";
		} else {
			context.setState(new FinallyState());
			return context.GetState();
		}

	}
}
