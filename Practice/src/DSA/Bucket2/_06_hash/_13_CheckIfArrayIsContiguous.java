package DSA.Bucket2._06_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/check-if-array-contains-contiguous-integers-with-duplicates-allowed2046/1
public class _13_CheckIfArrayIsContiguous {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 6, 4, 4, 6, 6 };

		TreeSet<Integer> ts = new TreeSet<Integer>();
		boolean isContiguous = true;

		for (int i = 0; i < arr.length; i++)
			ts.add(arr[i]);

		Iterator<Integer> itr = ts.iterator();
		int prev = 0;
		int curr = itr.next();

		while (itr.hasNext()) {

			prev = curr;
			curr = itr.next();

			if (Math.abs(prev - curr) != 1) {
				isContiguous = false;
				break;
			}

		}

		System.out.println(isContiguous);

	}
}
