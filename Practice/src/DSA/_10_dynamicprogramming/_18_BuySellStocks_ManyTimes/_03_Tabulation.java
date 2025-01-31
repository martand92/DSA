package DSA._10_dynamicprogramming._18_BuySellStocks_ManyTimes;

public class _03_Tabulation {

	public static int maxProfit(int[] stockPrices, int[][] dp) {

		for (int isBuy = 0; isBuy < 2; isBuy++)
			dp[stockPrices.length][isBuy] = 0;

		for (int i = stockPrices.length - 1; i >= 0; i--) {

			for (int j = 0; j < 2; j++) {// previously as isbuy starts from 1 and becomes 0, so starting from 0 here

				int pickProfit = 0;
				int notPickProfit = 0;

				if (j == 1) {
					pickProfit = dp[i + 1][0] + (-stockPrices[i]);
					notPickProfit = dp[i + 1][1];
				} else {
					pickProfit = dp[i + 1][1] + stockPrices[i];
					notPickProfit = dp[i + 1][0];
				}
				dp[i][j] = Math.max(pickProfit, notPickProfit);
			}
		}

		// System.out.println(Arrays.deepToString(dp));
		return dp[0][1]; // as i approaches to 0 and j approaches to 1 in above loops, hence final ans
							// should be stored in 0,1

	}

	public static void main(String[] args) {
		int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
		int[][] dp = new int[stockPrices.length + 1][2]; // 2 cz isBuy has only 2 values 1 or 0

		System.out.println(maxProfit(stockPrices, dp));
	}

}

//TC : O(n*2)
//SC : O(n * 2)