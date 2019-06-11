package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class T506 {
	int ss = 0;

	public static void main(String[] args) {
		int[] a = { 50, 20, 3, 400, 1 };
		String[] re = new String[a.length];

		IntStream.of(a).flatMap((p) -> {

			int[] b = IntStream.of(a).boxed().sorted().mapToInt(j -> j).toArray();
			System.out.println("p : " + p);
			System.out.println("b : " + Arrays.toString(b));
			for (int i = 0; i < b.length; i++) {

				System.out.println("b[i] : " + b[i]);

				if (p == b[i]) {
					if (i <= 1) {
						re[i] = "" + (i + 1) + "";
					} else if (i == 2) {
						re[i] = "Bronze Medal";
					} else if (i == 3) {
						re[i] = "Silver Medal";
					} else if (i == 4) {
						re[i] = "Gold Medal";
					}
					return IntStream.of(a);
				}

			}
			System.out.println("---------");

			return IntStream.of(a);
		}).toArray();

		// System.out.println("Anser : " +
		// Arrays.toString(IntStream.of(a).boxed().sorted(Comparator.comparing(p -> {
		// int[] b = IntStream.of(a).boxed().sorted().mapToInt(j -> j).toArray();
		// System.out.println("p : " + p);
		// for (int i = 0; i < b.length; i++) {
		// System.out.println("b : " + b[i]);
		// if (p == b[i]) {
		// if (i <= 1) {
		// re[i] = "" + (i + 1) + "";
		// } else if (i == 2) {
		// re[i] = "Bronze Medal";
		//
		// } else if (i == 3) {
		// re[i] = "Silver Medal";
		//
		// } else if (i == 4) {
		// re[i] = "Gold Medal";
		// }
		// return p;
		// }
		// }
		//
		// return -1;
		// })).toArray()));
		System.out.println(Arrays.toString(re));
		// System.out.println("Anser : " + Arrays.toString(findRelativeRanks(a)));

	}

	public static String[] findRelativeRanks2(int[] nums) {

		// String[] base = { "Gold Medal", "Silver Medal", "Bronze Medal" };
		// String[] re = new String[nums.length];
		// int[] copy = Arrays.copyOf(nums, nums.length);
		// Map<Integer, Integer> map = new HashMap<>();
		// Arrays.sort(copy);
		// for (int i = 0; i < nums.length; i++) {
		// map.put(copy[i], nums.length - 1 - i);
		// }
		//
		// int rank = 0;
		// for (int i = 0; i < nums.length; i++) {
		// rank = map.get(nums[i]);
		// re[i] = rank < 3 ? base[rank] : String.valueOf(rank + 1);
		// }
		return null;
	}

	public static String[] findRelativeRanks(int[] nums) {
		String[] base = { "Gold Medal", "Silver Medal", "Bronze Medal" };
		String[] re = new String[nums.length];
		int[] copy = Arrays.copyOf(nums, nums.length);
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(copy);
		for (int i = 0; i < nums.length; i++) {
			map.put(copy[i], nums.length - 1 - i);
		}

		int rank = 0;
		for (int i = 0; i < nums.length; i++) {
			rank = map.get(nums[i]);
			re[i] = rank < 3 ? base[rank] : String.valueOf(rank + 1);
		}
		return re;
	}
}
