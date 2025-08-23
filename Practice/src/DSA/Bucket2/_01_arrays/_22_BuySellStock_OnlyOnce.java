package DSA.Bucket2._01_arrays;

public class _22_BuySellStock_OnlyOnce {

	public static void main(String[] args) {

		int[] stockPrice = { 7, 1, 5, 3, 6, 4 };

		int minStockPrice = stockPrice[0];
		int maxProfit = 0;

		for (int i = 1; i < stockPrice.length; i++) {
			minStockPrice = Math.min(minStockPrice, stockPrice[i]);// if curr stock price is min then consider
			maxProfit = Math.max(maxProfit, (stockPrice[i] - minStockPrice)); // then check for max profit by selling
																				// current stock
		}

		System.out.println(maxProfit);

	}
}