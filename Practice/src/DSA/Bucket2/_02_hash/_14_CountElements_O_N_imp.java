package DSA.Bucket2._02_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/count-the-elements1529/1
public class _14_CountElements_O_N_imp {

	public static void main(String[] args) {

//		int a[] = { 4, 10, 2, 9, 3, 4, 1, 9, 8 };
//		int b[] = { 7, 3, 9, 2, 10, 10, 3, 4, 4 };
//		int q[] = { 5, 7, 2 };

		int a[] = { 1, 1, 5, 5 };
		int b[] = { 0, 1, 2, 3 };
		int q[] = { 0, 1, 2, 3 };
		int max = 0, count = 0;

		HashMap<Integer, Integer> map_bfreq = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map_b = new HashMap<Integer, Integer>();

		// First get the max of b array to create hashmap of frequency of b array ele
		for (int i = 0; i < b.length; i++)
			max = Math.max(max, b[i]);

		// find freq of each element in b array
		for (int i : b)
			map_bfreq.put(i, map_bfreq.getOrDefault(i, 0) + 1);

		// Find count of freq of freq map & add to map_b
		for (int i = 0; i <= max; i++) {
			count += map_bfreq.get(i);
			map_b.put(i, count);
		}

		// Then find elements less than a[q[i]]
		for (int i = 0; i < q.length; i++) {
			if (a[q[i]] <= map_b.size())
				q[i] = map_b.get(a[q[i]]);
			else
				q[i] = map_b.get(max);
		}

		System.out.println(Arrays.toString(q));
	}
}