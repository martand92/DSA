package DSA.Bucket2._01_arrays;

import java.util.HashSet;

//https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
public class _07_01_UnionOf2UnSortedArr {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 2, 3 };

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < a.length; i++)
			set.add(a[i]); // O(nlogn)

		for (int i = 0; i < b.length; i++)
			set.add(b[i]); // O(mlogm)

		System.out.println(set);

		// TC : O(nlogn + mlogm)
		// SC : O(n + m)
	}

}
