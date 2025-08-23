package DSA.Bucket2._09_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/sort-by-absolute-difference-1587115621/1
//Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.
public class _12_SortByAbsoluteDiff_Nice {

	public static void main(String[] args) {

		int[] arr = { 10, 5, 3, 9, 2 };
		int k = 4;

		Integer[] aInt = new Integer[arr.length];

		for (int i = 0; i < arr.length; i++)
			aInt[i] = arr[i];

		// While using comparator we couldn't use primitive type
		Arrays.sort(aInt, new Comparator<Integer>() {

			public int compare(Integer a, Integer b) {
				return (Math.abs(a - k) - Math.abs(b - k)); // no need to explicitly code if both diff (a-k) == (b-k),
															// by default it considers a and then b
			}

		});

		for (int i = 0; i < aInt.length; i++)
			arr[i] = aInt[i];

		System.out.println(Arrays.toString(arr));
	}
}
