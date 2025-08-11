package DSA.Bucket2._01_arrays._06_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1
public class _06_MaxSumOfArray_Nice {

	public static void main(String[] args) {

		int[] arr = { 1, 8, 3, 9, 4, 5, 7 };

		Arrays.sort(arr);
		long sum = 0;
		long mod = 1000000007;
		for (int i = 0; i < arr.length; i++)
			sum = (sum % mod + ((arr[i] % mod) * (i % mod)) % mod); // handling very large arrays
			

		System.out.println((int) (sum % mod));
	}
}