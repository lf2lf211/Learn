package designpattern.chainOfResp.ex2;

public class Client {
	private String leaveName;
	private int leaveDays;

	public Client(String leaveName, int leaveDays) {
		this.leaveName = leaveName;
		this.leaveDays = leaveDays;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public int getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
}
