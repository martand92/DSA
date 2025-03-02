package DSA.Bucket2._01_arrays._02_twoPointers;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/three-sum-closest/1
public class _04_FindTripletsWithNearestToGivenSum_ON2_Imp {

	public static void main(String[] args) {

		int[] arr = { -7, 9, 8, 3, 1, 1 };
		int target = 2;

//		int[] arr = { 5, 2, 7, 5 };
//		int target = 13;

		int finalSum = Integer.MAX_VALUE;

		// int res1 = 0, res2 = 0, res3 = 0;

		Arrays.sort(arr);

		outerloop: for (int i = 0; i < arr.length; i++) {

			int l = i + 1, r = arr.length - 1;
			int sum = 0;

			while (l < r) {

				sum = arr[i] + arr[l] + arr[r];

				if (Math.abs(sum - target) < finalSum)
					finalSum = sum;

				if (sum < target)
					l++;

				else if (sum > target)
					r--;

				else
					break outerloop;

			}
		}

		System.out.println(finalSum);

	}

}
