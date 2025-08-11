package DSA.Bucket2._07_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1
public class _10_SortBySetBitCount_Imp {

	public static void main(String[] args) {

		Integer[] arr = { 5, 2, 3, 9, 4, 6, 7, 15, 32 };

		Arrays.sort(arr, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return Integer.bitCount(o2) - Integer.bitCount(o1); // sort by number of bit counts in binary representation of integer
			}
		});

		System.out.println(Arrays.toString(arr));
	}

}
