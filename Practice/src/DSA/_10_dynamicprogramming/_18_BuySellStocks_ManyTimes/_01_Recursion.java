package DSA._10_dynamicprogramming._18_BuySellStocks_ManyTimes;

public class _01_Recursion {

	public static int maxProfit(int[] stockPrices, int day, int isBuy) {

		if (day == stockPrices.length)
			return 0;

		int pickProfit = 0;
		int notPickProfit = 0;

		// Either scenario will be to either buy or sell based on previous txn,
		// initially it will be Buy

		if (isBuy == 1) { // buy scenario : either you will buy or won't buy
			pickProfit = maxProfit(stockPrices, day + 1, 0) + (-stockPrices[day]);
			notPickProfit = maxProfit(stockPrices, day + 1, 1);

		} else { // sell scenario : either you will sell or won't sell
			pickProfit = maxProfit(stockPrices, day + 1, 1) + stockPrices[day];
			notPickProfit = maxProfit(stockPrices, day + 1, 0);
		}

		return Math.max(pickProfit, notPickProfit);
	}

	public static void main(String[] args) {
		int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(stockPrices, 0, 1));
	}
}
//TC : O(2^n)
//SC : O(n)