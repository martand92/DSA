package DSA.Bucket2._02_hash.Medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/three-sum-closest/1
public class _03_02_FindTripletsClosestToGivenSum_2Pointers {

	public static void main(String[] args) {

		int[] arr = { -7, 9, 8, 3, 1, 1 };
		int target = 2;

//		int[] arr = { 5, 2, 7, 5 };
//		int target = 13;

		int diff = 0, minDiff = Integer.MAX_VALUE, finalSum = 0;
		String triplets = new String();

		Arrays.sort(arr);

		outerloop: for (int i = 0; i < arr.length - 2; i++) {

			int l = i + 1, r = arr.length - 1;
			int sum = 0;

			while (l < r) {

				sum = arr[i] + arr[l] + arr[r];
				diff = Math.abs(target - sum);

				// if new diff is closer then consider their elements
				// if new diff is same as current min diff then consider max one
				if (diff < minDiff || (diff == minDiff && sum > finalSum)) {
					minDiff = diff;
					triplets = arr[i] + "," + arr[l] + "," + arr[r];
					finalSum = sum;
				}

				if (sum < target)
					l++;
				else if (sum > target)
					r--;
				else
					break outerloop;

			}
		}

		System.out.println(triplets);
	}

}
