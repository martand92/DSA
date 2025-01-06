package DSA._03_hash;

import java.util.*;

//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class _03_01_FindLargestSubArrWithZeroSum {

	public static void main(String[] args) {
		// int[] arr = { 15, -2, 2, -8, 1, 7 };
		int[] arr = { -42, 12, 20, 15, 31, -4, 0, 15 };
		// int[] arr = { -1, 1, -1, 1 };
		int sum = 0, maxLength = 0, len = 0;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // O(n)

		for (int i = 0; i < arr.length; i++) { // O(n)
			sum += arr[i];

			if (sum == 0)
				maxLength = i + 1;

			if (hm.containsKey(sum)) { // if true, found sub array with sum zero. O(logn)
				len = i - hm.get(sum); // calculate length of found sub array with sum = 0
				maxLength = Math.max(len, maxLength); // check if found length of subarray is > current maxLen

			} else
				hm.put(sum, i); // Storing index of each found sum to check for largest window. O(logn)

		}

		System.out.println(maxLength);

		// TC : O(n * logn)
		// SC : O(n)
	}

}