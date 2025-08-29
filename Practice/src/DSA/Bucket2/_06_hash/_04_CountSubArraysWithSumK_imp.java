package DSA.Bucket2._06_hash;

import java.util.HashMap;

//Why Sliding window won't work?
// Sliding window relies on monotonic property where sum should increase or
// decrease. This happens if array contains only non-neg elements

// But here as it contains neg elements, this behavior of increasing or
// decreasing monotonically breaks
// ex : when arr[2] + arr[3] = 9 but 9 + arr[4] = 6

//Hash with prefixSum

public class _04_CountSubArraysWithSumK_imp {

	public static int numOfSubArrWithSumK(int[] arr, int k) {

		HashMap<Integer, Integer> prefixFreq = new HashMap<Integer, Integer>();// holds frequency of prefixSum at i
		int prefixSum = 0, count = 0;

		for (int i = 0; i < arr.length; i++) {

			prefixSum += arr[i];// prefixSum

			if (prefixSum == k) // subarray from starting index that sums up to k, hence increase count by 1
				count++;

			// As we saw in zero sum, if prefixSum repeats there exists intermediate sub
			// array that sums upto 0. This problem is extention to it

			// Here check if current prefixSum - target(k) is already seen, then
			// there exists subarray that sums upto target

			// Now there could be multiple subarrays that would have summed upto intended
			// target(k) before.

			// Hence, to current count add all the occurrences of previously seen intended
			// prefixsum(CurrentPrefixSum-k)
			if (prefixFreq.containsKey(prefixSum - k))
				count += prefixFreq.get(prefixSum - k);

			prefixFreq.put(prefixSum, prefixFreq.getOrDefault(prefixSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {

//		int[] arr = { 4, 2, 2, 6, 4 };
//		int k = 6;

		int[] arr = { 1, 2, 3, -3, 1, 1, 1 };
		int k = 3;

		System.out.println(numOfSubArrWithSumK(arr, k));
	}
}