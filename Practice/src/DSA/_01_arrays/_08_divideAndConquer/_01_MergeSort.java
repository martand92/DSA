package DSA._01_arrays._08_divideAndConquer;

import java.util.Arrays;

//https://www.happycoders.eu/algorithms/merge-sort/
public class _01_MergeSort { // https://www.youtube.com/watch?v=bOk35XmHPKs

	static int[] arr = { 64, 25, 12, 22, 11 };

	public static void mergeSort(int[] arr, int[] left, int[] right) {

		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {

			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}

			k++;
		}

		// remaining elements
		while (i < left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}

	}

	public static void divide(int[] arr) {

		// Base condition of recursion, when reached recursion stops. Stops when array
		// length is less than 2 after multiple divisions
		if (arr.length < 2)
			return;

		// Create 2 new arrays left and right with half the size for each
		int[] left = new int[arr.length / 2];
		int[] right = new int[arr.length - arr.length / 2]; // Can't have just arr.length / 2 here as arr.length can be
															// odd. So taking size from mid to end for right array

		// Insert elements for both left and right arrays
		for (int i = 0; i < left.length; i++)
			left[i] = arr[i];

		for (int i = 0; i < right.length; i++)
			right[i] = arr[arr.length / 2 + i];

		// First divide left side till array.length < 2
		divide(left);

		// After completing left then start dividing right
		divide(right);

		// update initial array itself while merging in sorted manner
		mergeSort(arr, left, right); // arr is pass by reference, then when returns it contains updated arr
		// It updates first sorted array to left[] because it was initiated by left
		// array as part of divide()

	}

	public static void main(String[] args) {

		// First divide array to halves
		divide(arr);

		System.out.println(Arrays.toString(arr));

	}
}
