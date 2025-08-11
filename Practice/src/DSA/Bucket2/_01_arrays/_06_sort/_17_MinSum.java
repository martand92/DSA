package DSA.Bucket2._01_arrays._06_sort;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/minimum-sum4058/1
public class _17_MinSum {

	public static void main(String[] args) {

		int[] arr = { 6, 8, 4, 5, 2, 3 };
		Arrays.sort(arr);

		String num1 = new String();
		String num2 = new String();

		if (arr.length == 1)
			System.out.println(arr[0]);

		else {
			for (int i = 0; i < arr.length; i = i + 2)
				num1 += String.valueOf(arr[i]);

			for (int i = 1; i < arr.length; i = i + 2)
				num2 += String.valueOf(arr[i]);

			System.out.println(Long.valueOf(num1) + Long.valueOf(num2));
		}
	}

}
