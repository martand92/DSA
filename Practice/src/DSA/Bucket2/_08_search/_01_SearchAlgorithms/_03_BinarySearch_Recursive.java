package DSA.Bucket2._08_search._01_SearchAlgorithms;

import java.util.Arrays;

public class _03_BinarySearch_Recursive {

	public static boolean binarySearch(int[] arr, int key, int l, int r) {

		if (l > r)
			return false;

		int mid = (l + r) / 2;

		if (arr[mid] == key)
			return true;

		else if (arr[mid] < key)
			return binarySearch(arr, key, mid + 1, r);
		else
			return binarySearch(arr, key, l, mid - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
		int key = 10;
		Arrays.sort(arr);
		System.out.println(binarySearch(arr, key, 0, arr.length - 1));
	}
}