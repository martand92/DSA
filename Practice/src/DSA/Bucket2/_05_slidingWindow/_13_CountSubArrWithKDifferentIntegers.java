package DSA.Bucket2._05_slidingWindow;

import java.util.HashMap;

// changing problem statement to 
// find count of all subarrays with <= k different integers -> x
// find count of all subarrays with <= k-1 different integers -> y
// Therefore find count of all subarrays with k different integers as x - y

// WHy this problem cannot be solved using hashmap + prefixSum?
// Cz its not a linear function as count of distinct numbers in a subarray isn’t directly derivable from prefix values.
// This happens because the set of distinct elements isn’t additive — overlaps between subarrays break the prefix trick.
// Prefix sum works for quantities that can be added.

public class _13_CountSubArrWithKDifferentIntegers {

	// find all the sub arrays containing k different integers
	public static int countOfSubArrWithKDifferentIntegers(int[] nums, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int l = 0, count = 0;

		for (int r = 0; r < nums.length; r++) { // O(N)

			hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);

			while (hm.size() > k) { // O(N)

				hm.put(nums[l], hm.get(nums[l]) - 1);

				if (hm.get(nums[l]) == 0)
					hm.remove(nums[l]);

				l++;
			}

			// count all subarrays that results in size of <=k
			count += r - l + 1;
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3 };
		int k = 2;
		System.out.println(
				countOfSubArrWithKDifferentIntegers(nums, k) - countOfSubArrWithKDifferentIntegers(nums, k - 1));
	}

}
//TC : O(2 * (N+N))
//SC : O(1)
