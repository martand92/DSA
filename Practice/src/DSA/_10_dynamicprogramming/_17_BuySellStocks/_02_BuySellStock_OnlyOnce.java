package DSA._10_dynamicprogramming._17_BuySellStocks;

public class _02_BuySellStock_OnlyOnce {

	public static int maxProfit(int[] stockPrices, int i, boolean isBuy) {

		if (i == stockPrices.length)
			return 0;

		int pick = 0, notPick = 0;

		if (!isBuy) { // Need to sell
			pick = stockPrices[i]; // When Sell just stock value
			notPick = maxProfit(stockPrices, i + 1, false);
		}
		if (isBuy) {
			pick = maxProfit(stockPrices, i + 1, false) + (-stockPrices[i]); // Buying
			notPick = maxProfit(stockPrices, i + 1, true); // Not Buying
		}

		return Math.max(pick, notPick);
	}

	public static void main(String[] args) {
		int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(stockPrices, 0, true));
	}
}