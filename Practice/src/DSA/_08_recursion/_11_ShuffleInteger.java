package DSA._08_recursion;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/shuffle-integers2401/1
public class _11_ShuffleInteger {
	static int n;
	public static int[] shuffleArr(int[] arr, int l, int r) {

		if (r == arr.length)
			return arr;

		int left = arr[l];
		int right = arr[r];

		arr = shuffleArr(arr, l + 1, r + 1);

		arr[n--] = right;
		arr[n--] = left;
		return arr;

	}

	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 9, 15 };
		n = arr.length - 1;
		arr = shuffleArr(arr, 0, arr.length / 2);

		System.out.println(Arrays.toString(arr));
	}

}
