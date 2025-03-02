package DSA.Bucket2._03_hash;

import java.util.HashMap;

public class _04_NumOfSubArrWithSumK {

	public static int numOfSubArrWithSumK(int[] arr, int k) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int prefixSum = 0, count = 0;

		for (int i = 0; i < arr.length; i++) {

			prefixSum += arr[i];

			if (prefixSum == k)
				count++;

			else if (hm.containsKey(prefixSum - k))
				count += hm.get(prefixSum - k);

			hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -3, 1, 1, 1 };
		int k = 3;

		System.out.println(numOfSubArrWithSumK(arr, k));
	}

}
