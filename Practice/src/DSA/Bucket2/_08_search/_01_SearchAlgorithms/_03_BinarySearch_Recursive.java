package DSA.Bucket2._08_search._01_SearchAlgorithms;

import java.util.Arrays;

public class _03_BinarySearch_Recursive {

	static int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
	final static int KEY = 9;
	static int low = 0;
	static int high = arr.length - 1;

	// below mid index fails for large values > 2^31
	// static int mid = (low + high) / 2;

	static int mid = low + (high - low) / 2; // For above issue this method can be used to calculate mid index

	public static void main(String[] args) {
		Arrays.sort(arr);
		binarySearch(arr, mid);
	}

	public static int binarySearch(int[] arr, int mid) {

		if (KEY == arr[mid]) {
			System.out.println("Key found");
			return 1;
		} else if (KEY < arr[mid])
			high = mid - 1;

		else if (KEY > arr[mid])
			low = mid + 1;

		if (low < high)
			return binarySearch(arr, low + (high - low) / 2);
		else {
			System.out.println("Key not found ");
			return -1;
		}
	}

}
