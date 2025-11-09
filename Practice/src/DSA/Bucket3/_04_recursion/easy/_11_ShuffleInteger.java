package DSA.Bucket3._04_recursion.easy;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/shuffle-integers2401/1
public class _11_ShuffleInteger {

	public static int[] shuffleArr(int[] arr, int i) {

		if (i == arr.length / 2)
			return arr;

		int a = arr[i];
		int b = arr[(arr.length / 2) + i];

		arr = shuffleArr(arr, i + 1);

		arr[i * 2] = a;
		arr[i * 2 + 1] = b;

		return arr;
	}

	public static void main(String[] args) {
		// int arr[] = { 1, 2, 9, 15 };
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(shuffleArr(arr, 0)));
	}
}