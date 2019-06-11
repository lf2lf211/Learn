package chainOfResp.ex2;

public class GroupLeader extends Handler {
	public GroupLeader(String name) {
		super(name);
	}

	public void handleRequest(Client request) {
		if (request.getLeaveDays() <= 1) {
			System.out.println(
					"组长" + name + "审批员工" + request.getLeaveName() + "的请假条，请假天数为" + request.getLeaveDays() + "天。");
		} else {
			if (this.successor != null) {
				this.successor.handleRequest(request);
			}
		}
	}
}
