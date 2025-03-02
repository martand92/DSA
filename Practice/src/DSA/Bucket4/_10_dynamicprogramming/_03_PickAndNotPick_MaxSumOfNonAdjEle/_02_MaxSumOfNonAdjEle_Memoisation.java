package DSA.Bucket4._10_dynamicprogramming._03_PickAndNotPick_MaxSumOfNonAdjEle;

import java.util.Arrays;

public class _02_MaxSumOfNonAdjEle_Memoisation {

	public static int findMaxSumOfNonAdjEle(int[] arr, int n, int[] dp) {

		if (n == 0)
			return arr[n];

		if (n < 0)
			return 0;

		if (dp[n] != -1)
			return dp[n];

		int leftSum = findMaxSumOfNonAdjEle(arr, n - 2, dp) + arr[n];
		int rightSum = findMaxSumOfNonAdjEle(arr, n - 1, dp);

		return dp[n] = Math.max(leftSum, rightSum);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);

		System.out.println(findMaxSumOfNonAdjEle(arr, arr.length - 1, dp));
	}
}
