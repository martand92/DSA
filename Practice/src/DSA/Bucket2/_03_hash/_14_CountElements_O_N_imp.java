package DSA.Bucket2._03_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/count-the-elements1529/1
public class _14_CountElements_O_N_imp {

	public static void main(String[] args) {

		int a[] = { 4, 10, 2, 9, 3, 4, 1, 9, 8 };
		int b[] = { 7, 3, 9, 2, 10, 10, 3, 4, 4 };
		int q[] = { 5, 7, 2 };
		int max = 0;
		int count = 0;

		HashMap<Integer, Integer> hmb = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hmbFreq = new HashMap<Integer, Integer>();

		// First get the max of b array to create hashmap of frequency of b array ele
		for (int i = 0; i < b.length; i++)
			max = Math.max(max, b[i]);

		for (int i : b)
			hmbFreq.put(i, hmbFreq.getOrDefault(i, 0) + 1);

		// Create frequency of b arr elements for each index till b max
		for (int i = 1; i <= max; i++) {
			if (hmbFreq.containsKey(i))
				count += hmbFreq.get(i);

			hmb.put(i, count);
		}

		// Then find elements less than a[q[i]]
		for (int i = 0; i < q.length; i++) {
			if (a[q[i]] <= hmb.size())
				q[i] = hmb.get(a[q[i]]);
			else
				q[i] = hmb.get(max);

		}

		System.out.println(Arrays.toString(q));

	}
}
