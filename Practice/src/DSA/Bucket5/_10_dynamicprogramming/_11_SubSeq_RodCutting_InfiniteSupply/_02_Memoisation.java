package DSA.Bucket5._10_dynamicprogramming._11_SubSeq_RodCutting_InfiniteSupply;

import java.util.Arrays;

public class _02_Memoisation {

	public static int maxRodPrice(int n, int[] price, int index, int[][] dp) {

		if (n == 0)
			return 0;

		if (index == 0) {
			if (n >= index + 1)
				return n * price[index];
		}

		if (dp[index][n] != -1)
			return dp[index][n];

		int pick = Integer.MIN_VALUE;
		if (n >= index + 1)
			pick = maxRodPrice(n - (index + 1), price, index, dp) + price[index];

		int notPick = maxRodPrice(n, price, index - 1, dp);

		return dp[index][n] = Math.max(pick, notPick);
	}

	public static void main(String[] args) {
		int n = 5;
		int[] price = { 2, 5, 7, 8, 10 };

		int[][] dp = new int[price.length][n + 1];
		for (int rows = 0; rows < price.length; rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(maxRodPrice(n, price, price.length - 1, dp));

	}

}
