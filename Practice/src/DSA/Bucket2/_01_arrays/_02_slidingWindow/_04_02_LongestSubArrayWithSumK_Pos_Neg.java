package DSA.Bucket2._01_arrays._02_slidingWindow;

import java.util.*;

//Below solution works for both positive and negative nums in array 

//this problem is same as : _03_01_FindLargestSubArrayWithSumZero
public class _04_02_LongestSubArrayWithSumK_Pos_Neg {

	public static int longestSubArr(int[] arr, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int sum = 0, maxLength = 0;

		for (int i = 0; i < arr.length; i++) { // O(n)

			sum += arr[i];

			if (sum == k)
				maxLength = i + 1;

			else {

				if (hm.containsKey(sum - k)) // O(logn)
					maxLength = Math.max(maxLength, i - hm.get(sum - k));

				else {
					// if same sum is seen again then don't update its index as longest subarray is
					// needed
					if (!hm.containsKey(sum)) // O(logn)
						hm.put(sum, i);
				}
			}

		}

		return maxLength;

		// TC : O(n * logn)
		// SC : O(1)
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
