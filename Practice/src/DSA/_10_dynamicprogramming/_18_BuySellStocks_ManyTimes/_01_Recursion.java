package DSA._10_dynamicprogramming._18_BuySellStocks_ManyTimes;

public class _01_Recursion {

	public static int maxProfit(int[] stockPrices, int day, int isBuy) {

		if (day == stockPrices.length)
			return 0;

		int pickProfit = 0;
		int notPickProfit = 0;

		// buy scenario : either you will buy or won't buy
		if (isBuy == 1) {
			pickProfit = -stockPrices[day] + maxProfit(stockPrices, day + 1, 0);
			notPickProfit = 0 + maxProfit(stockPrices, day + 1, 1);

		} else { // sell scenario : either you will sell or won't sell
			pickProfit = stockPrices[day] + maxProfit(stockPrices, day + 1, 1);
			notPickProfit = 0 + maxProfit(stockPrices, day + 1, 0);
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