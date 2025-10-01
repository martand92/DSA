package DSA.Bucket2._02_2Pointers;

import java.util.Arrays;

public class _13_01_MoveAllZerosToLast {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[] moveZerosToLast_Opt(int[] arr) {

		int initZeroIdx = -1;

		for (int i = 0; i < arr.length; i++) {

			// find first occurrence of 0
			if (initZeroIdx == -1 && arr[i] == 0)
				initZeroIdx = i;

			// then check if element is non zero then swap it with first occurrence of 0
			else if (initZeroIdx != -1 && arr[i] != 0) {
				swap(arr, i, initZeroIdx);
				initZeroIdx++;
			}
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
