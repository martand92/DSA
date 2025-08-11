package DSA.Bucket2._01_arrays;

//https://www.youtube.com/watch?v=IexN60k62jo
//https://www.naukri.com/code360/problems/merge-all-overlapping-intervals_6783452

import java.util.*;

public class _20_MergeOverlappingSubIntervals_imp {

	public static int countOverlappingIntervals(int[][] arr) {

		int count = 1;
		// First sort given matrix by first element of each row and if they are equal
		// then second element of each row so that overlapping can be easily found
		Arrays.sort(arr, new Comparator<int[]>() {

			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return a[0] - b[0];
				else
					return a[1] - b[1];
			}
		});
		// System.out.println(Arrays.deepToString(arr));

		// Check if 2nd element of first row is greater than first element of second row
		// then second row is overlapping with first row
		for (int i = 1; i < arr.length; i++) {

			if (arr[i - 1][1] < arr[i][0])
				count++;
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		System.out.println(countOverlappingIntervals(arr));
	}

}
