package DSA.Bucket2._04_hash;

import java.util.HashMap;

public class _05_01_CountPairsWithGivenSum_Imp {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1 };
		int sum = 2;

		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (hm.containsKey(sum - arr[i]))
				count += hm.get(sum - arr[i]);

			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		System.out.println(count);
	}
}
