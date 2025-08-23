package DSA.Bucket2._06_hash;

import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
public class _02_SubArrayWithZeroSum {

	public static void main(String[] args) {

		int[] arr = { 4, 2, -3, 1, 6 };
		int sum = 0;

		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i]; // prefix sum

			if (arr[i] == 0 || sum == 0 || hs.contains(sum)) {
				System.out.println("Yes");
				return;
			}

			hs.add(sum);
		}

		System.out.println("No");
	}

}