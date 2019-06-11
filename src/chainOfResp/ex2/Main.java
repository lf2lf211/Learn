package chainOfResp.ex2;

public class Main {
	public static void main(String args[]) {
		Handler groupLeader, manager, hr;

		groupLeader = new GroupLeader("王明");
		manager = new Manager("赵强");
		hr = new HRDepartment("李波");

		groupLeader.setSuccessor(manager); // 排传递顺序
		manager.setSuccessor(hr);

		Client lr1 = new Client("张三", 1);
		groupLeader.handleRequest(lr1);

		Client lr2 = new Client("李四", 2);
		groupLeader.handleRequest(lr2);

		Client lr3 = new Client("王五", 5);
		groupLeader.handleRequest(lr3);

		Client lr4 = new Client("赵六", 10);
		groupLeader.handleRequest(lr4);
	}

}
