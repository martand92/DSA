package DSA._01_arrays._02_twoPointers;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
public class _04_CheckIfTripletsExistWith0Sum_ON2_Imp {

	public static boolean has3Sum(int[] arr) {

		Arrays.sort(arr);// for 2 pointer , sorting is must

		for (int i = 0; i < arr.length - 1; i++) {

			int l = i + 1;
			int r = arr.length - 1;

			while (l < r) {

				if ((arr[i] + arr[l] + arr[r]) == 0)
					return true;

				if ((arr[i] + arr[l] + arr[r]) < 0)
					l++;

				if ((arr[i] + arr[l] + arr[r]) > 0)
					r--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 0, -1, 2, -3, 1 };
		System.out.println(has3Sum(arr));
	}
}