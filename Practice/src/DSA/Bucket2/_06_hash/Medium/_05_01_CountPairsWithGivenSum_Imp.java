package DSA.Bucket2._06_hash.Medium;

import java.util.HashMap;

//Logic is same as TwoSUm except array elements here are dup
//The sum is fixed (2 here), not changing, What varies are the elements we see and how many of their complements exist. 
//Hence in we store freq of arr elements

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