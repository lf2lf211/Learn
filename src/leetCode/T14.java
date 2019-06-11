package leetCode;

public class T14 {

	public static void main(String[] args) {
		String[] a = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(a));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length < 1 || strs == null) {
			return "";
		}
		// 如果長度為1直接回傳
		if (strs.length == 1) {
			return strs[0];
		}

		int shorts = 0;
		int len = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			int curLen = strs[i].length();
			if (curLen < len) {
				len = curLen;
				shorts = i;
			}
		}

		String sub = strs[shorts];
		for (int i = 0; i < strs.length; i++) {
			while (strs[i].indexOf(sub) != 0) {
				sub = sub.substring(0, sub.length() - 1);
			}
		}
		return sub;
	}
}
