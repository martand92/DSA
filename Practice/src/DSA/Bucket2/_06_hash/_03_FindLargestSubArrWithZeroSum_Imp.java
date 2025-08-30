package DSA.Bucket2._06_hash;

import java.util.*;

//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class _03_FindLargestSubArrWithZeroSum_Imp {

	public static void main(String[] args) {

		// int[] arr = { 15, -2, 2, -8, 1, 7 };
		int[] arr = { -42, 12, 20, 15, 31, -4, 0, 15 };
		// int[] arr = { -1, 1, -1, 1 };
		int prefixSum = 0, maxLength = 0, len = 0;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // O(n)

		for (int i = 0; i < arr.length; i++) { // O(n)

			prefixSum += arr[i];

			if (prefixSum == 0)
				maxLength = i + 1;

			else if (hm.containsKey(prefixSum)) { // if true, found sub array with sum zero. O(logn)
				len = i - hm.get(prefixSum);
				maxLength = Math.max(len, maxLength);
			}

			if (!hm.containsKey(prefixSum))
				hm.put(prefixSum, i); // O(logn)
		}

		System.out.println(maxLength);

		// TC : O(n * logn)
		// SC : O(n)
	}

}