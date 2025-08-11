package DSA.Bucket2._07_sort;

import java.util.Arrays;

//O(N^2)
public class _02_0_BubbleSort_ON2 {

	static int[] arr = { 64, 25, 12, 22, 11 };
	static int temp;

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - i - 1; j++) { // In every iteration as last element sorted as highest, it
															// will be ignored in every iteration

				if (arr[j] > arr[j + 1]) {

					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

}
