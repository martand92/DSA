package DSA.Bucket2._08_search._01_SearchAlgorithms;

import java.util.Arrays;

//array must be sorted
public class _03_BinarySearch {

	static int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
	final static int KEY = 10;
	static int low = 0, high = arr.length - 1;
	static int mid = (low + high) / 2;

	public static void main(String[] args) {
		Arrays.sort(arr);

		while (low <= high) {
			if (KEY == arr[mid]) {
				System.out.println("Key found");
				break;
			} else if (KEY < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

			mid = (high + low) / 2;

		}

		if (low > high)
			System.out.println("Key " + KEY + " was not found");

	}

}
