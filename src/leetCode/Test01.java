package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;
import java.util.function.IntFunction;
import java.util.stream.IntStream;


public class Test01 {
	public static int[] twoSum2(int[] nums, int target) {

		HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (tracker.containsKey(nums[i])) {
				int left = tracker.get(nums[i]);
				return new int[] { left + 1, i + 1 };
			} else {
				tracker.put(target - nums[i], i);
			}
		}
		return new int[2];
	}

	public static int[] twoSum3(int[] numbers, int target) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			Integer diff = (Integer) (target - numbers[i]);
			if (hash.containsKey(diff)) {
				int toReturn[] = { hash.get(diff) + 1, i + 1 };
				return toReturn;
			}
			hash.put(numbers[i], i);
		}
		return null;
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] eresult = { 0, 0 };
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) != null) {
				int[] result = { map.get(nums[i]) + 1, i + 1 };
				return result;
			}
			map.put(target - nums[i], i);
		}
		return eresult;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 8 };
		System.out.println(Arrays.toString(twoSum(a, 5)));
		System.out.println(Arrays.toString(twoSum2(a, 5)));
		System.out.println(Arrays.toString(twoSum3(a, 5)));

		// Iterator<int[]> d = Stream
		// .of(IntStream.of(a).filter((arr) -> arr % 2 == 0).toArray(),
		// IntStream.of(a).filter((arr) -> arr % 2 != 0).toArray())
		// .collect(Collectors.toList()).iterator();
		// ArrayList<Integer> ddd = new ArrayList<Integer>();
		// while (d.hasNext()) {
		// for (int i : d.next()) {
		// System.out.println(i);
		// ddd.add(i);
		// }
		// }

		// System.out.println("Anser : " + Arrays.toString(ddd.toArray()));

		// IntStream.of(a).boxed().sorted(aa->)
		// Test01 main = new Test01();
		// System.out.println("Anser : " + Arrays.toString(main.sortArrayByParity(a)));
	}

	public IntFunction aaaa(int i) {
		if (i % 2 == 1) {
		}
		return null;

	}

	public int[] sortArrayByParity(int[] a) {
		return IntStream.of(a).boxed().sorted(Comparator.comparingInt(p -> {
			if (p % 2 == 1) {
				return p;
			}
			return -1;
		})).mapToInt(i -> i).toArray();
	}

	public static int[] sortArrayByParityJava8(int[] a) {

		Comparator<Integer> cmp = (Integer o1, Integer o2) -> (o1 = o1 % 2).compareTo(o2 % 2);

		return IntStream.of(a).boxed().sorted(cmp).mapToInt(i -> i).toArray();
	}

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			System.out.println(stack);
			System.out.println("result   " + result);
			System.out.println("sign   " + sign);
			System.out.println("number   " + number);

			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				number = 10 * number + (int) (c - '0');
			} else if (c == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				// we push the result first, then sign;
				stack.push(result);
				stack.push(sign);
				// reset the sign and result for the value in the parenthesis
				sign = 1;
				result = 0;

			} else if (c == ')') {
				result += sign * number;
				number = 0;
				result *= stack.pop();    // stack.pop() is the sign before the parenthesis
				result += stack.pop();   // stack.pop() now is the result calculated before the
										   // parenthesis

			}
		}
		if (number != 0)
			result += sign * number;
		return result;
	}
}
