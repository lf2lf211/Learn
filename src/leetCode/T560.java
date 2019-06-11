package leetCode;

import java.util.HashMap;


public class T560 {
	// 就是用三层for loop，找到所有可能的subarray，并遍历subarray中的每个数，计算subarray的和。
	// 1 1 1
	// i
	// j - > 0 1 2
	// Time O (n^3) Space : O(1)
	public static int subarraySum1(int[] nums, int k) {
		int count = 0;
		// 所有可能的i
		for (int i = 0; i < nums.length; i++) {
			// 所有可能的j
			for (int j = i; j < nums.length; j++) {
				// 找尋和
				int sum = 0;
				// 所有元素加起來
				for (int index = i; index <= j; index++) {
					sum += nums[index];
				}
				if (sum == k)
					count++;
			}
		}
		return count;
	}

	// 暴力
	// 从上一个解法出发，我们能看到一个比较明显的优化就是减少重复计算。
	// 在Naive的解法中，在计算subarray的和的时候，我们每次都需要遍历该subarray中的每个数。实际上，这是有很多重复的。
	// 那么，减少重复的一个方法，就是把之前已经计算过的subarray(i,
	// j)的和保存下来，当j++的时候我们只需要在原来的和的基础上加上新的nums[j]，来达到减少重复遍历的目的，也降低了时间复杂度。
	// Time O (n^2) Space : O(1)
	public static int subarraySum2(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					++count;
				}
			}
		}
		return count;
	}

	/// precomputation的技巧：prefixSum array。
	/// x, .... y(sum=1), z...w(sum=1), ... t(sum=6)
	/// k = 5 -> {[y..t], [w..t]} : count=2
	// Time O (n^1) Space : O(n)
	public static int subarraySum3(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		// 1, 2, 1, 2, 1 k = 3
		// 0 1 3 4 6 7
		// i
		// 3 4
		// <0,1> <1,1> <3,1> <4,1> <6,1> <7,1>
		// 1
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// sum - k = 0
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		System.out.println(map);
		return count;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 1, 2, 1 };

		System.out.println(subarraySum3(a, 3));
	}
}
