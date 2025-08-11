package DSA.Bucket2._01_arrays._06_sort;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/maximize-toys0331/1
public class _08_MaximizeToys_Imp {

	public static void main(String[] args) {

		int[] arr = { 1, 12, 5, 111, 200, 1000, 10 };
		int k = 50, i = 0;

		Arrays.sort(arr);

		for (i = 0; i < arr.length && k > 0; i++)
			k -= arr[i];

		if (k >= 0) // if given amount is not yet exhausted
			System.out.println(i);
		else
			System.out.println(i - 1);
	}
	
}