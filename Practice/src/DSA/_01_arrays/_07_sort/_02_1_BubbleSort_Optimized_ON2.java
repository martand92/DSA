package DSA._01_arrays._07_sort;

import java.util.Arrays;

public class _02_1_BubbleSort_Optimized_ON2 {

	static int[] arr = { 11, 12, 22, 64, 25 };
	static int temp;
	static boolean swapped = false;

	public static void main(String[] args) {

		for (int i = 0; i < arr.length; i++) {

			swapped = false;

			for (int j = 0; j < arr.length - i - 1; j++) {

				if (arr[j] > arr[j + 1]) {

					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true; // In every iteration of bubble sort, as it traverse from first element to last
									// element - i, if swapping isn't done then all elements before "last element -
									// i" is already sorted so need to go through remaining iterations

				}

			}

			if (!swapped)
				break;

		}

		System.out.println(Arrays.toString(arr));
	}

}
