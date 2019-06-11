package leetCode;

import java.util.Stack;


public class T227 {
	public static void main(String[] args) {

		String s = " 3+5 / 2 ";
		int a = calculate(s);
		System.out.println(a);
	}

	public static int calculate(String s) {

		int len = s.length();
		int num = 0;
		Stack<Integer> stack = new Stack<Integer>();
		// sign紀錄本次數字之前的上一个運算，初始值為'+'，
		char sign = '+';
		for (int i = 0; i < len; i++) {
			System.out.println(stack);
			// 他是不是數字
			if (Character.isDigit(s.charAt(i))) {
				// 要-0不然會是chat
				num = num * 10 + s.charAt(i) - '0';
			}
			// 先乘除后加减
			if ((!Character.isDigit(s.charAt(i))
					// 非空格
					&& ' ' != s.charAt(i))
					// 到达字符串结束处，需要计算最后一次结果
					|| i == len - 1) {
				// 加减不计算结果，直接压入栈，运算符优先级
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				// 乘除从栈中拿出並刪除一个數字计算结果，在塞進去
				if (sign == '*') {
					// 123-8*2
					// +123-8
					// +123
					// +123-16
					//
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}
		int res = 0;
		// 從stack拿出來計算
		for (int i : stack) {
			res += i;
		}
		return res;
	}
}
