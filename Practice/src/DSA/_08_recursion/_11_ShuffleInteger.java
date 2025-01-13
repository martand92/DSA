package DSA._08_recursion;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/shuffle-integers2401/1
public class _11_ShuffleInteger {

	public static int[] shuffleArr(int[] arr, int l, int r, int n) {

		if (r == arr.length)
			return arr;

		int n1 = arr[l];
		int n2 = arr[r];

		arr = shuffleArr(arr, l + 1, r + 1, n - 1);

		// figuring out this index is the real trick, kept another variable n to use it
		// while backtracking
		arr[r - n] = n2;
		arr[r - n - 1] = n1;

		return arr;
	}

	public static void main(String[] args) {
		// int arr[] = { 1, 2, 9, 15 };
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(shuffleArr(arr, 0, arr.length / 2, (arr.length - 1) / 2)));
	}
}
