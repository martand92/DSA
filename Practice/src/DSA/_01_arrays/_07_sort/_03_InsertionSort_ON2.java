package DSA._01_arrays._07_sort;

import java.util.Arrays;

public class _03_InsertionSort_ON2 {

	static int[] arr = { 12, 11, 13, 5, 6 };
	static int temp;

	public static void main(String[] args) {

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {

				if (arr[j - 1] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
