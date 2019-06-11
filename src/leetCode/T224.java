package leetCode;
import java.util.Stack;


public class T224 {
	public static void main(String[] args) {

		String s1 = "5+(1+(4+5+2)-3)+(6+8)";
		String s2 = "(1+(4+(5+8)-(1-8))-3)+(6+8)-(-(-9)+(-3))";
		String s3 = "(1+(4+(5-2))-3)+(6+8)";
		String s4 = "(1+(4-(5+2))-3)+(6+8)";
		System.out.println(calculate3(s1));
		System.out.println(calculate3(s2));
		System.out.println(calculate3(s3));
		System.out.println(calculate3(s4));
	}

	public static int calculate3(String s) {
		Stack<Integer> stackInt = new Stack<Integer>();
		int result = 0, sign = 1, num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				num = 10 * num + c - '0';
			} else if (c == '+' || c == '-') {
				result += num * sign;
				num = 0;
				sign = c == '+' ? 1 : -1;
			} else if (c == '(') {
				stackInt.push(result);
				stackInt.push(sign);
				result = 0;
				sign = 1;
			} else if (c == ')') {
				result += num * sign;
				result = result * stackInt.pop() + stackInt.pop();
				num = 0;
				sign = 1;
			}
		}
		result += num * sign;
		return result;
	}

	private static int num = 0;
	private static int result = 0;
	private static int sign = 1;

	public static int calculate2(String s) {

		Stack<Integer> signs = new Stack<Integer>();
		s = "(" + s + ")";

		s.chars().filter((c) -> ("0123456789+-()".contains(String.valueOf((char) (c))))).forEach((c) -> {
			System.out.println("signs  " + signs);
			System.out.println("num  " + num);
			System.out.println("result  " + result);
			System.out.println("-------------------------");

			if (c >= '0' && c <= '9') {
				num = 10 * num + c - '0';
			} else if (c == '+' || c == '-') {
				result = result + signs.peek() * sign * num;
				num = 0;
				sign = (c == '+') ? 1 : -1;
			} else if (c == '(') {
				if (!signs.isEmpty())
					signs.push(sign * signs.peek());
				else
					signs.push(sign);
				sign = 1;
			} else if (c == ')') {
				result = result + signs.pop() * sign * num;
				num = 0;
				sign = 1;
			}
		});
		return result;
	}

	public static int calculate(String s) {

		int len = s.length();
		int num = 0;
		int result = 0;
		int has = 0;
		Stack<Integer> stack = new Stack<Integer>();
		// sign紀錄本次數字之前的上一个運算，初始值為'+'，
		char sign = '+';

		for (int i = 0; i < len; i++) {
			sign = s.charAt(i);
			// 他是不是數字
			if (Character.isDigit(sign)) {
				// 要-0不然會是chat
				num = num * 10 + sign - '0';

				if (has == 1) {
					result = result + num;
				}
			}
			// 先乘除后加减
			if ((!Character.isDigit(sign)
					// 非空格
					&& ' ' != sign)
					// 到达字符串结束处，需要计算最后一次结果
					|| i == len - 1) {

				// 加减不计算结果，直接压入栈，运算符优先级
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}

				if (sign == '(') {
					if (has == 1) {
						stack.push(result);
						result = 0;
					}
					has = 1;
				}
				if (sign == ')') {
					stack.push(result);
					result = 0;
					has = 0;
				}
				num = 0;
				if (i == len - 1) {
					stack.push(result);
				}
			}
			System.out.println("sign  " + sign);
			System.out.println("has  " + has);

			System.out.println("stack   " + stack);
			System.out.println("當下result   " + result);
			System.out.println("s.charAt(i)   " + s.charAt(i));
			System.out.println("-----------第" + i + "次--------------");
		}
		int res = 0;
		// 從stack拿出來計算
		for (int i : stack) {
			res += i;
		}

		return res;
	}

}
