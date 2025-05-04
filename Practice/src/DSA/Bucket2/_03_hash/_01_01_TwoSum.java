package DSA.Bucket2._03_hash;

//https://practice.geeksforgeeks.org/problems/key-pair5616/1

import java.util.*;

public class _01_01_TwoSum {

	public static boolean hasTwoSum_Brute(int[] arr, int k) {

		HashSet<Integer> hs = new HashSet<Integer>(); // O(n)

		for (int i = 0; i < arr.length; i++) {// O(n)

			if (hs.contains(k - arr[i])) // O(logn)
				return true;
			else
				hs.add(arr[i]);
		}

		return false;

		// TC : O(n * log n)
		// SC : O(n)
	}

	public static boolean hasTwoSum_Opt(int[] arr, int k) {

		Arrays.sort(arr); // O(nlogn)

		int l = 0, r = arr.length - 1;

		while (l <= r) { // O(n)

			if (arr[l] + arr[r] > k)
				r--;

			else if (arr[l] + arr[r] < k)
				l++;

			else
				return true;
		}

		return false;
		// TC : O(nlogn + n)
		// SC : O(1)
	}

	public static void main(String[] args) {

		int[] arr = { 1, 4, 45, 6, 10, 8 };
		int k = 16;

		System.out.println(hasTwoSum_Brute(arr, k));
		System.out.println(hasTwoSum_Opt(arr, k));

	}
}