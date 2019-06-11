package designpattern.statePattern;

public class Context {
	private State state;
	private String action;

	public String GetState() {
		return state.GetState(this);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Context() {
		this.state = new StartState();
		this.action = "申請";
	}

	@Override
	public String toString() {
		return "Context [state=" + state + ", action=" + action + "]";
	}

}
