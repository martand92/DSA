package DSA.Bucket4._10_dynamicprogramming._19_BuySellStocks_AtMost2Times;

public class _01_Recursion {

	public static int maxProfit(int[] stockPrices, int day, int isBuy, int txCount) {

		// if both transactions are completed by selling stocks, then you wont' get any
		// profit. Hence returning 0
		if (txCount == 0)
			return 0;

		// when all the days are exhausted for buying / selling, as no more days left
		// you cannot sell or buy. Hence you make no profit
		if (day == stockPrices.length)
			return 0;

		int pickProfit = 0, notPickProfit = 0;

		if (isBuy == 1) {
			pickProfit = maxProfit(stockPrices, day + 1, 0, txCount) + (-stockPrices[day]);
			notPickProfit = maxProfit(stockPrices, day + 1, 1, txCount);

		} else {
			// transaction will be completed only after selling
			pickProfit = maxProfit(stockPrices, day + 1, 1, txCount - 1) + stockPrices[day];
			notPickProfit = maxProfit(stockPrices, day + 1, 0, txCount);
		}

		return Math.max(pickProfit, notPickProfit);
	}

	public static void main(String[] args) {
		int[] stockPrices = { 3, 3, 5, 0, 3, 1, 4 };
		System.out.println(maxProfit(stockPrices, 0, 1, 2));
	}

}
