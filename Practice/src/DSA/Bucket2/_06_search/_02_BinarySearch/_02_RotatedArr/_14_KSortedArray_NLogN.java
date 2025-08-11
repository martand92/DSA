package DSA.Bucket2._06_search._02_BinarySearch._02_RotatedArr;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/k-sorted-array1610/1
public class _14_KSortedArray_NLogN {

	public static boolean isKsorted(int[] arr, int k) {

		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			arr1[i] = arr[i];
		Arrays.sort(arr1);

		for (int i = 0; i < arr.length; i++) {

			int l = 0, r = arr1.length - 1;
			int mid = 0;

			while (l <= r) {

				mid = l + (r - l) / 2;

				if (arr[i] == arr1[mid]) {

					if (Math.abs(i - mid) > k)
						return false;
					else
						break;

				} else if (arr[i] > arr1[mid])
					l = mid + 1;

				else
					r = mid - 1;
			}
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

		System.out.println(isKsorted(arr, k));

	}

}
