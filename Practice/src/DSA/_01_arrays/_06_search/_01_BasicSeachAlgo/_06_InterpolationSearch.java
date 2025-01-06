package DSA._01_arrays._06_search._01_BasicSeachAlgo;

import java.util.Arrays;

public class _06_InterpolationSearch {

	static int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
	final static int KEY = 9; // not working for 9
	static int low = 0;
	static int high = arr.length - 1;

	// pos = lo + (x - arr[lo]) *(hi - lo) / (arr[hi] - arr[lo])

	static int mid = low + (KEY - arr[low]) * (high - low) / (arr[high] - arr[low]); // this formula not sure if it
																						// passes all tests

	public static void main(String[] args) {
		Arrays.sort(arr);
		while (low <= high && mid < arr.length && mid > -1) {
			if (KEY == arr[mid]) {
				System.out.println("Key found");
				break;
			} else if (KEY < arr[mid])
				high = mid - 1;
			else
				low = mid + 1;

			mid = low + (KEY - arr[low]) * (high - low) / (arr[high] - arr[low]);
		}

		if (low > high || mid > arr.length || mid < 0)
			System.out.println("Key not found");
	}

}
