package statePattern;

public class FinallyState extends State {

	@Override
	public String GetState(Context context) {
		if (context.getAction().equals("結束")) {
			return "該單結案";
		}
		return null;

	}

}
