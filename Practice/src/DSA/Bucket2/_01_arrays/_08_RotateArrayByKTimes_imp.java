package DSA.Bucket2._01_arrays;

import java.util.*;

public class _08_RotateArrayByKTimes_imp {

	public static int[] rotateArr_Brute1(int[] arr, int k) {
		int[] res = new int[arr.length];
		int n = arr.length;

		k = k % n;

		for (int i = 0; i < n; i++)
			res[i] = arr[(k + i) % n];

		return res;
		// TC:O(n), SC:O(n)

	}

	public static int[] rotateArr_Brute2(int[] arr, int k) {
		int temp = 0;
		int n = arr.length;
		k = k % n;

		for (int i = 0; i < k; i++) {

			temp = arr[0];

			for (int j = 0; j < n - 1; j++)
				arr[j] = arr[j + 1];

			arr[n - 1] = temp;
		}

		return arr;

		// TC:O(k*(n-1)), SC:O(n)
	}

	public static int[] rotateArr_Brute3(int[] arr, int k) {

		Queue<Integer> q = new LinkedList<Integer>();
		int n = arr.length;
		k = k % n;

		for (int i = n - k - 1; i < n; i++)
			q.add(arr[i]);

		for (int i = 0; i < n - k - 1; i++)
			q.add(arr[i]);

		int i = 0;
		while (!q.isEmpty()) {
			arr[i] = q.remove();
			i++;
		}

		return arr;

		// TC:O(k + (n-k) + n) -> O(2n), SC:O(n)
	}

	// https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
	public static void reverse(int[] arr, int start, int end) {
		int temp = 0;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static int[] reversalAlgo(int[] arr, int k) {

		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

		// TC:O(k + n-k + n) -> O(2n), SC : O(1)

		return arr;
	}

	public static void main(String[] arg) {
		// int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 2;

		System.out.println(Arrays.toString(rotateArr_Brute1(arr.clone(), k)));
		System.out.println(Arrays.toString(rotateArr_Brute2(arr.clone(), k)));
		System.out.println(Arrays.toString(rotateArr_Brute3(arr.clone(), k)));
		System.out.println(Arrays.toString(reversalAlgo(arr.clone(), k)));
	}
}
