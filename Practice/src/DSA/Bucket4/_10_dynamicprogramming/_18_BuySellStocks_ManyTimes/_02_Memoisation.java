package DSA.Bucket4._10_dynamicprogramming._18_BuySellStocks_ManyTimes;

public class _02_Memoisation {

	public static int maxProfit(int[] stockPrices, int day, int isBuy, int[][] dp) {

		if (day == stockPrices.length)
			return 0;

		int pickProfit = 0;
		int notPickProfit = 0;

		if (dp[day][isBuy] != -1)
			return dp[day][isBuy];

		if (isBuy == 1) {
			pickProfit = maxProfit(stockPrices, day + 1, 0, dp) + (-stockPrices[day]);
			notPickProfit = maxProfit(stockPrices, day + 1, 1, dp);
		} else {
			pickProfit = maxProfit(stockPrices, day + 1, 1, dp) + stockPrices[day];
			notPickProfit = maxProfit(stockPrices, day + 1, 0, dp);
		}

		return dp[day][isBuy] = Math.max(pickProfit, notPickProfit);
	}

	public static void main(String[] args) {
		int[] stockPrices = { 7, 1, 5, 3, 6, 4 };

		// as there are 2 variables, stockPrices and buy/sell
		int[][] dp = new int[stockPrices.length][2]; // 2 cz isBuy has only 2 values : 1 or 0

		for (int i = 0; i < stockPrices.length; i++) {
			for (int j = 0; j < 2; j++) { // buy / sell
				dp[i][j] = -1;
			}

		}

		System.out.println(maxProfit(stockPrices, 0, 1, dp));
	}

}

//TC : O(2^n)
//SC : O(n)