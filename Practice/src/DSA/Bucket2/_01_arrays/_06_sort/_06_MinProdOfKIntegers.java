package DSA.Bucket2._01_arrays._06_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/minimum-product-of-k-integers2553/1
public class _06_MinProdOfKIntegers {

	public static void main(String[] args) {

		int[] arr = { 9, 10, 8 };
		int k = 3;
		Arrays.sort(arr);

		long mod = 1000000007;
		long prod = 1;

		for (int i = 0; i < k; i++)
			prod = (prod * arr[i]) % mod;

		System.out.println((int) prod);
	}
}
