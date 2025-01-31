package DSA._10_dynamicprogramming._19_BuySellStocks_AtMost2Times;

public class _03_Tabulation {

	public static int maxProfit(int[] stockPrices, int day, int isBuy, int txCount, int[][][] dp) {

		for (int i = 0; i < stockPrices.length; i++)// days
			for (int j = 0; j < 2; j++)// buy / sell
				dp[i][j][0] = 0;

		for (int i = 0; i < 2; i++)// for buy/sell
			for (int j = 0; j <= 2; j++) // for txCount
				dp[stockPrices.length][i][j] = 0;

		for (int i = stockPrices.length - 1; i >= 0; i--) {

			for (int j = 0; j < 2; j++) { // for buy / sell. As Buy moves from 1 -> 0 in memoisation, here reverse

				for (int k = 1; k < 3; k++) { // for tx count. As txCount moves from 2 -> 0 in memoisation, here reverse

					int pickProfit = 0, notPickProfit = 0;

					if (j == 1) {
						pickProfit = dp[i + 1][0][k] + (-stockPrices[i]);
						notPickProfit = dp[i + 1][1][k];

					} else {
						pickProfit = dp[i + 1][1][k - 1] + stockPrices[i];
						notPickProfit = dp[i + 1][0][k];
					}

					dp[i][j][k] = Math.max(pickProfit, notPickProfit);

				}
			}
		}

		return dp[0][1][2];
	}

	public static void main(String[] args) {

		int[] stockPrices = { 3, 3, 5, 0, 3, 1, 4 };

		int[][][] dp = new int[stockPrices.length + 1][2][3];
		
		System.out.println(maxProfit(stockPrices, 0, 1, 2, dp));
	}

}
