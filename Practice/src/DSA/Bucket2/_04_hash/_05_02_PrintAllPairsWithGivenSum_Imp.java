package DSA.Bucket2._04_hash;

import java.util.*;

public class _05_02_PrintAllPairsWithGivenSum_Imp {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 1 };
		int sum = 2;

		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++) {

			if (hm.containsKey(sum - arr[i])) {
				for (int j = 0; j < hm.get(sum - arr[i]); j++)
					al.add(arr[i] + "," + (sum - arr[i]));
			}

			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		}

		System.out.println(al);

	}
}
