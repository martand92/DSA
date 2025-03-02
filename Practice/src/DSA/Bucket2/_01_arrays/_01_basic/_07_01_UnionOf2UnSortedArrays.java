package DSA.Bucket2._01_arrays._01_basic;

import java.util.HashSet;

//https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
public class _07_01_UnionOf2UnSortedArrays {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 2, 3 };

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++)
			set.add(a[i]);

		for (int i = 0; i < b.length; i++)
			set.add(b[i]);

		System.out.println(set);

		// TC : O(n + m)
		// SC : O(n + m)
	}

}
