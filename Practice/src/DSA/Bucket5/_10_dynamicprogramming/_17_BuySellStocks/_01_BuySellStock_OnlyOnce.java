package DSA.Bucket5._10_dynamicprogramming._17_BuySellStocks;

public class _01_BuySellStock_OnlyOnce {

	public static void main(String[] args) {

		int[] stockPrice = { 7, 1, 5, 3, 6, 4 };

		int min = stockPrice[0];
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < stockPrice.length; i++) {
			maxProfit = Math.max(maxProfit, (stockPrice[i] - min));
			min = Math.min(min, stockPrice[i]);
		}

		System.out.println(maxProfit);

	}

}
