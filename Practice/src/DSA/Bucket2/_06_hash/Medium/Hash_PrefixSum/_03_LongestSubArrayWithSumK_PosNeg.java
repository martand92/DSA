package DSA.Bucket2._06_hash.Medium.Hash_PrefixSum;

import java.util.*;

//Below solution works for both positive and negative nums in array 
public class _03_LongestSubArrayWithSumK_PosNeg {

	public static int longestSubArr(int[] arr, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int sum = 0, maxLength = 0;

		for (int i = 0; i < arr.length; i++) { // O(n)

			sum += arr[i];

			if (sum == k)
				maxLength = i + 1;

			else if (hm.containsKey(sum - k))// O(logn)
				maxLength = Math.max(maxLength, i - hm.get(sum - k));

			if (!hm.containsKey(sum)) // O(logn)
				hm.put(sum, i);
		}

		return maxLength;

		// TC : O(n * logn)
		// SC : O(n)
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 1, 1, 4, 2, 3 };
		int k = 3;

//		int[] arr = { -59, -25, 58, -59, -25, 58 };
//		int k = -85;

//		int[] arr = { 2, 0, 0, 3 };
//		int k = 3;

		System.out.println(longestSubArr(arr, k));
	}

}
