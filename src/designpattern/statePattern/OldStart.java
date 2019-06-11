package designpattern.statePattern;

public class OldStart {
	static String workOrderState = "申請";

	public static void main(String[] args) {

		System.out.println("OldStart工作單現在狀態:" + GetState());
		System.out.println("OldStart工作單現在狀態:" + GetState());
		System.out.println("OldStart工作單現在狀態:" + GetState());
		System.out.println("OldStart工作單現在狀態:" + GetState());
	}

	private static String GetState() {

		String result = "";
		if (workOrderState == "申請") {
			result = "工作單申請";
			workOrderState = "負責人";
		} else if (workOrderState == "負責人") {
			result = "負責人處理中";
			workOrderState = "使用者";
		} else if (workOrderState == "使用者") {
			result = "使用者確認中";
			workOrderState = "結束";
		} else if (workOrderState == "結束") {
			result = "該單結案";
		}
		return result;
	}
}
