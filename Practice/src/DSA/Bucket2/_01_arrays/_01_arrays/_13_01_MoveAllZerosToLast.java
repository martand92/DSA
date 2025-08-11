package DSA.Bucket2._01_arrays._01_arrays;

import java.util.Arrays;

public class _13_01_MoveAllZerosToLast {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[] moveZerosToLast_Opt(int[] arr) {

		int i = 0, j = 0;

		while (i < arr.length) {

			// find first occurrence of 0 and point j to it
			// j will henceforth point to only first occurrence of 0
			if (arr[j] != 0)
				// i++;
				j++;

//			else if (arr[i] == 0 && arr[j] == 0) {
//				i++;
//			}

			// then check if element is non zero then swap it with first occurrence of 0
			else if (arr[i] != 0) {
				swap(arr, i, j);
				j++;
			}

			i++;
		}

		return arr;

		// TC : O(n)
		// SC : O(1)
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 3, 2, 0, 0, 11, 6 };
		System.out.println(Arrays.toString(moveZerosToLast_Opt(arr)));
	}
}
