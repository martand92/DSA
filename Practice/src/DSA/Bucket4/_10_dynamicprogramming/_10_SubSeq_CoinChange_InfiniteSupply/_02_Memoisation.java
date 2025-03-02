package DSA.Bucket4._10_dynamicprogramming._10_SubSeq_CoinChange_InfiniteSupply;

import java.util.Arrays;

public class _02_Memoisation {

	public static int countCoins(int[] arr, int index, int target, int[][] dp) {

		if (target == 0)
			return 1;

		if (index == 0) {
			// since coins are unlimited, target can be formed with multiple arr elements
			if (target % arr[index] == 0)
				return 1;
			else
				return 0;
		}

		if (dp[index][target] != -1)
			return dp[index][target];
		
		int pick = 0;
		if (target >= arr[index])
			pick = countCoins(arr, index, target - arr[index], dp);

		int notPick = countCoins(arr, index - 1, target, dp);

		return dp[index][target] = pick + notPick;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int target = 4;

		int[][] dp = new int[arr.length][target + 1];
		for (int rows = 0; rows < arr.length; rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(countCoins(arr, arr.length - 1, target, dp));
	}

}
