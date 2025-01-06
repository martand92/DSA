package DSA._03_hash.Medium;

import java.util.*;

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

			if (k == 0) { // handle 0 difference differently 
				
				if (e.getValue() > 1)
					hs.add(String.valueOf(e.getKey() + "," + e.getKey()));
				
			} else if (hm.containsKey(e.getKey() + k)) // for each entry, check if element + givenDifference is already present 
				hs.add(e.getKey() + "," + (e.getKey() + k)); // only unique pairs should be added, if 
		}

		System.out.println(hs.size());
	}
}
