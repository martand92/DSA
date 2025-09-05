package DSA.Bucket2._06_hash.Medium;

import java.util.*;

/*  Algo : 
 * 
 *  a - b = k, then a = k + b
 *  Now only unique pair are needed, remove duplicates by hashing
 *  
 *  Why hashmap? : 
 *  to handle k=0, Without hashmap & with only hashset, as initially you add all elements to hash.
 *  if arr={1,2,3} then only with hashset when you check if another paired element exists after doing k+arr[i], it results in same arr[i] as k=0
 *  so even if no pair exists k+arr[i] will find same element from hash.
 *  
 *  Hence its important to handle k = 0 differently by check if same element appears more than once to form pair
 */

//https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1
public class _05_03_CountDistinctPairsWithGivenDifference_VeryImp {

	public static void main(String[] args) {
		int[] nums = { 1, 5, 4, 1, 2 };
		int k = 0;

//		int[] nums = { 1, 5, 3 };
//		int k = 2;

//		int[] nums = { 12, 9, 10, 13, 1, 8, 11 };
//		int k = 7;

		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;

		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1); // consolidate duplicates

		for (int e : hm.keySet()) {

			if (k == 0) {
				if (hm.get(e) > 1) // if k == 0 then you need to check if same element is repeating, only
					// then they make valid pair
					count++;

			} else if (hm.containsKey(k + e))// if not then check if k+arr[i] exists, then makes valid pair
				count++;
		}

		System.out.println(count);
	}
}