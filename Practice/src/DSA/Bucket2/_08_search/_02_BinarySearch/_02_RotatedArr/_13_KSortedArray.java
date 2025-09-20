package DSA.Bucket2._08_search._02_BinarySearch._02_RotatedArr;

import java.util.Arrays;

/* Algo : 
 * As you need to check for the relative elements from given rotated array with sorted array, first create a sortedArray of given rotated arrays
 * Then look for each element from rotated array in sorted array and check for their index difference
 * if index difference is greater than k then given array is not k sorted
 * */

//https://practice.geeksforgeeks.org/problems/k-sorted-array1610/1
public class _13_KSortedArray {

	public static int binarySearch(int[] arr, int l, int r, int key) {

		int mid = 0;

		while (l <= r) {

			mid = (l + r) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;// never occurs
	}

	public static boolean isKsorted(int[] arr, int[] sortedArr, int k) {

		for (int i = 0; i < arr.length; i++) {
			int index = binarySearch(sortedArr, 0, arr.length - 1, arr[i]);
			if (Math.abs(index - i) > k)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

//		int[] arr = { 3, 2, 1, 5, 6, 4 };
//		int k = 2;

//		int[] arr = { 18, 44, 12, 27, 4, 19, 42, 8, 34, 15, 38, 5, 16, 47, 1, 6, 32, 40, 10, 33, 22 };
//		int k = 18;

		int[] arr = { 10, 27, 13, 28, 31, 29, 15, 7, 30, 19, 47, 49, 25, 2, 20, 43, 44, 35, 12 };
		int k = 12;

		int[] sortedArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sortedArr);
		System.out.println(isKsorted(arr, sortedArr, k));
	}
}