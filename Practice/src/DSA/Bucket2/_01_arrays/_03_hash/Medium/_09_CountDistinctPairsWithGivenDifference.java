package DSA.Bucket2._01_arrays._03_hash.Medium;

import java.util.*;

/*  Algo : 
 * 
 *  a - b = k, then a = k + b
 *  Now only unique pair are needed, remove duplicates by hashing
 *  
 *  Why hashmap? : 
 *  1. to remove duolicates (but we can use hashset as well)
 *  2. to handle k=0, where you need to check if same element appears more than 1 as its difference results in 0 
 */

//https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1
public class _09_CountDistinctPairsWithGivenDifference {

	public static void main(String[] args) {
//		int[] arr = { 1, 5, 4, 1, 2 };
//		int diff = 0;

		int[] nums = { 12, 9, 10, 13, 1, 8, 11 };
		int k = 7;

		HashMap<Integer, Integer> hm = new HashMap<>();
		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1); // first remove duplicates and store count of duplicates

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {

			if (k == 0) { // handling k=0
				if (e.getValue() > 1)
					hs.add(String.valueOf(e.getKey() + "," + e.getKey()));

			} else if (hm.containsKey(k + e.getKey()))
				hs.add(e.getKey() + "," + (k + e.getKey())); // only unique pairs should be considered
		}

		System.out.println(hs.size());
	}
}