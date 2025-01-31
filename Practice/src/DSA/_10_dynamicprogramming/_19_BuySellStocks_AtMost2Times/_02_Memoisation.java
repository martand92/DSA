package DSA._10_dynamicprogramming._19_BuySellStocks_AtMost2Times;

public class _02_Memoisation {

	public static int maxProfit(int[] stockPrices, int day, int isBuy, int txCount, int[][][] dp) {

		// if both transactions are completed by selling stocks, then you wont' get any
		// profit. Hence returning 0
		if (txCount == 0)
			return 0;

		// when all the days are exhausted for buying / selling, as no more days left
		// you cannot sell or buy. Hence you make no profit
		if (day == stockPrices.length)
			return 0;

		if (dp[day][isBuy][txCount] != -1)
			return dp[day][isBuy][txCount];

		int pickProfit = 0, notPickProfit = 0;

		if (isBuy == 1) {
			pickProfit = maxProfit(stockPrices, day + 1, 0, txCount, dp) + (-stockPrices[day]);
			notPickProfit = maxProfit(stockPrices, day + 1, 1, txCount, dp);

		} else {
			// transaction will be completed only after selling
			pickProfit = maxProfit(stockPrices, day + 1, 1, txCount - 1, dp) + stockPrices[day];
			notPickProfit = maxProfit(stockPrices, day + 1, 0, txCount, dp);
		}

		return dp[day][isBuy][txCount] = Math.max(pickProfit, notPickProfit);
	}

	public static void main(String[] args) {
		int[] stockPrices = { 3, 3, 5, 0, 3, 1, 4 };

		// as there are 3 variables, stockPrices, to buy / sell, max 2 txcount
		int[][][] dp = new int[stockPrices.length][2][3]; // as txCount varies between 0 <-> 2, need 3 place holders

		for (int i = 0; i < stockPrices.length; i++) {

			for (int j = 0; j < 2; j++) {// buy or sell

				for (int k = 0; k <= 2; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		System.out.println(maxProfit(stockPrices, 0, 1, 2, dp));
	}

}
