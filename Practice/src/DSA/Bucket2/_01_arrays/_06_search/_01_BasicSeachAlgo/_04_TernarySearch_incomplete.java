package DSA.Bucket2._01_arrays._06_search._01_BasicSeachAlgo;

import java.util.Arrays;

public class _04_TernarySearch_incomplete {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
		int key = 2;
		int l = 0, r = arr.length - 1;
		boolean found = false;

		Arrays.sort(arr);

		while (l <= r) {

			int mid1 = l + (r - l) / 3, mid2 = r - (r - l) / 3;

			if (key == arr[mid1]) {
				found = true;
				break;
			}

			else if (key == arr[mid2]) {
				found = true;
				break;
			}

			else if (key < arr[mid1])
				r = mid1 - 1;

			else if (key > arr[mid1] && key < arr[mid2]) {
				l = mid1 + 1;
				r = mid2 - 1;
			}

			else if (key > arr[mid2])
				l = mid2 + 1;
		}

		System.out.println(found);

	}
}
