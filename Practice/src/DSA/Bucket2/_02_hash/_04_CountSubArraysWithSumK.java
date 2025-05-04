package DSA.Bucket2._02_hash;

import java.util.HashMap;

public class _04_CountSubArraysWithSumK {

	public static int numOfSubArrWithSumK(int[] arr, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int sum = 0, count = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (sum == k)
				count++;

			else if (hm.containsKey(sum - k))
				count += hm.get(sum - k);

			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {

		int[] arr = { 4, 2, 2, 6, 4 };
		int k = 6;

//		int[] arr = { 1, 2, 3, -3, 1, 1, 1 };
//		int k = 3;

		System.out.println(numOfSubArrWithSumK(arr, k));
	}

}
