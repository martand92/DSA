package DSA.Bucket2._06_hash.Medium;

import java.util.*;

// Intuition : to find a^b=target, then a=target^b. 
// Hence if xor of current prefix xor & target results in prev prefix xor then increase counter by prev xor freq    

//Algo :
// start finding xor of elements in given array from index 0.
// if resultant xor = target then increase count by 1 and add it to hm 
// if resultant xor != target then add it to hm
// if resultant xor exists already in hashmap with freq, then increase count by hm freq and add it to hm
public class _04_CountSubArrayWithXorK {

	public static void main(String[] args) {

		int[] arr = { 4, 2, 2, 6, 4 };
		int target = 6;

		int count = 0, xor = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();// O(n)

		for (int i = 0; i < arr.length; i++) { // O(n)
			xor ^= arr[i];

			if (xor == target)
				count++;

			if (hm.containsKey(target ^ xor)) // O(logn)
				count += hm.get(target ^ xor);

			hm.put(xor, hm.getOrDefault(xor, 0) + 1);// O(logn)

		}

		System.out.println(count);

		// TC : O(n * 2logn)
		// SC : O(n)

	}

}