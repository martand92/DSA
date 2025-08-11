package DSA.Bucket2._01_arrays._06_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/smallest-subset-with-greater-sum/1
public class _11_SmallestSubSetWithGreaterSum_Nice {

	public static void main(String[] args) {

		int[] arr = { 2, 17, 7, 3 };

		Arrays.sort(arr);

		int l = 0, r = arr.length - 1;
		long sum = arr[l], lastSum = arr[r];
		int lastSumCount = 1;

		while (l < r) {

			if (sum < lastSum) {
				l++;
				sum += arr[l];

			} else {
				r--;
				lastSum += arr[r];
				lastSumCount++;
			}
		}

		System.out.println(lastSumCount);
	}

}
