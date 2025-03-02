package DSA.Bucket4._10_dynamicprogramming._11_SubSeq_RodCutting_InfiniteSupply;

public class _03_Tabulation {

	public static int maxRodPrice(int n, int[] price, int[][] dp) {

		for (int index = 0; index < price.length; index++)
			dp[index][0] = 0;

		for (int i = 0; i <= n; i++) {
			if (i >= 1)
				dp[0][i] = i * price[0];
		}

		for (int index = 1; index < price.length; index++) {

			for (int j = 0; j <= n; j++) {

				int pick = Integer.MIN_VALUE;

				if (j >= index + 1)
					pick = dp[index][j - (index + 1)] + price[index];

				int notPick = dp[index - 1][j];

				dp[index][j] = Math.max(pick, notPick);
			}
		}

		return dp[price.length - 1][n];

	}

	public static void main(String[] args) {
		int n = 5;
		int[] price = { 2, 5, 7, 8, 10 };

		int[][] dp = new int[price.length][n + 1];

		System.out.println(maxRodPrice(n, price, dp));

	}

}
