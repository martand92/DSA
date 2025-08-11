package DSA.Bucket2._01_arrays;

import java.util.*;

//https://www.geeksforgeeks.org/problems/common-elements1132/1
public class _07_03_FindCommonIn3SortedArrays {

	public static List<Integer> findCommonElements_Brute(int[] a, int[] b, int[] c) {

		LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<Integer, Integer>();// O(n+ m + k)
		List<Integer> result = new ArrayList<Integer>();// O(min(n + m + k))

		for (int i = 0; i < a.length; i++)
			lhm.put(a[i], lhm.getOrDefault(a[i], 0) + 1);

		for (int i = 0; i < b.length; i++)
			lhm.put(b[i], lhm.getOrDefault(b[i], 0) + 1);

		for (int i = 0; i < c.length; i++)
			lhm.put(c[i], lhm.getOrDefault(c[i], 0) + 1);

		for (Map.Entry<Integer, Integer> e : lhm.entrySet()) {// if all elements are unique in all 3 arrays then TC :
																// O(n+m+k)
			if (e.getValue() % 3 == 0)
				result.add(e.getKey());

		}

		return result;

		// TC : O(nlogn + mlogm + klogk + (n + m + k))
		// SC : O(n+ m + k + min(n + m + k))
	}

	public static List<Integer> findCommonElements_Opt(int[] a, int[] b, int[] c) {

		// assign 3 pointers to 3 arrays
		// if all 3 elements are same then check if its already part of result then
		// add it to result and move all 3 pointers by 1
		// else if whichever is the lowest element, move its pointer by 1
		int i = 0, j = 0, k = 0;
		List<Integer> result = new ArrayList<Integer>(); // O(min(n + m + k))

		while (i < a.length && j < b.length && k < c.length) { // O(n + m + k)

			if (a[i] == b[j] && b[j] == c[k]) {

				// first check if result already contains this element by referring to last
				// result val as its sorted.
				if (result.size() == 0 || (result.size() > 0 && result.get(result.size() - 1) != a[i]))
					result.add(a[i]);

				i++;
				j++;
				k++;

			} else if (a[i] < b[j] && a[i] < c[k])
				i++;

			else if (b[j] < a[i] && b[j] < c[k])
				j++;

			else
				k++;
		}

		return result;

		// TC : O(n + m + k)
		// SC : O(min(n + m + k))
	}

	public static void main(String[] args) {

//		int[] A = { 1, 5, 10, 20, 40, 80 };
//		int[] B = { 6, 7, 20, 80, 100 };
//		int[] C = { 3, 4, 15, 20, 30, 70, 80, 120 };

		int[] A = { 3, 3, 3 };
		int[] B = { 3, 3, 3 };
		int[] C = { 3, 3, 3 };

		System.out.println(findCommonElements_Brute(A, B, C));
		System.out.println(findCommonElements_Opt(A, B, C));
	}

}
