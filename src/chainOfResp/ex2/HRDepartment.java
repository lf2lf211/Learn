package chainOfResp.ex2;

public class HRDepartment extends Handler {
	public HRDepartment(String name) {
		super(name);
	}

	public void handleRequest(Client request) {
		if (request.getLeaveDays() >= 5) {
			System.out.println(
					"人事部门" + name + "审批员工" + request.getLeaveName() + "的请假条，请假天数为" + request.getLeaveDays() + "天。");
		} else {
			if (this.successor != null) {
				this.successor.handleRequest(request);
			}
		}
	}
}
