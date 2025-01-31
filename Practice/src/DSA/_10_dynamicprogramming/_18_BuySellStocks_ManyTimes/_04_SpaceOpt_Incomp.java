package DSA._10_dynamicprogramming._18_BuySellStocks_ManyTimes;

public class _04_SpaceOpt_Incomp {

	public static int maxProfit(int[] stockPrices) {

//		for (int isBuy = 0; isBuy < 2; isBuy++)
//			dp[stockPrices.length][isBuy] = 0;

		int ahead = 0;
		int ahead1 = 0;

		for (int i = stockPrices.length - 1; i >= 0; i--) {

			for (int j = 0; j < 2; j++) {// previously as isbuy starts from 1 and becomes 0, so starting from 0 here

				int pickProfit = 0;
				int notPickProfit = 0;

				if (j == 1) {
					pickProfit = ahead + (-stockPrices[i]);
					notPickProfit = ahead1;
				} else {
					pickProfit = ahead1 + stockPrices[i];
					notPickProfit = ahead;
				}
				ahead1 = ahead;
				ahead = Math.max(pickProfit, notPickProfit);
			}
		}

		return ahead1;

	}

	public static void main(String[] args) {
		int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(stockPrices));
	}
}

//TC : O(n*2)
//SC : O(n)