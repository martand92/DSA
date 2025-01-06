package DSA._01_arrays._06_search._01_BasicSeachAlgo;

import java.util.Arrays;

public class _07_ExponentialBinarySearch {

	static int[] arr = { 1, 5, 4, 7, 3, 9, 2, 6, 8 };
	final static int KEY = 2;
	static int i = 0;
	static int low = 0;
	static int high = 0;

	public static void main(String[] args) {
		Arrays.sort(arr);

		while (i < arr.length) {
			if (arr[i] == KEY) {
				System.out.println("Key found");
				break;
			} else if (KEY < arr[i]) {
				low = i / 2;
				high = i;
				break;
			} else {
				i++;
				i = (int) Math.pow(2, i);
			}
		}

		System.out.println(Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length - 1), KEY));
	}

}
