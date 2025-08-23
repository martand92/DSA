package DSA.Bucket2._09_sort;

import java.util.*;

//O(N^2)
public class _01_SelectionSort_ON2 {

	// static int[] arr = { 64, 25, 12, 22, 11 };
	static int[] arr = { 4, 2, 1, 5, 3 };

	public static void main(String[] args) {

		for (int i = 0; i < arr.length; i++) {

			int minIndex = i, temp; // consider i'th element as lowest in every iteration

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[minIndex] > arr[j])
					minIndex = j;
			}

			// Then replace current element(i) with lowest element found
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}

		System.out.println(Arrays.toString(arr));

	}

}
