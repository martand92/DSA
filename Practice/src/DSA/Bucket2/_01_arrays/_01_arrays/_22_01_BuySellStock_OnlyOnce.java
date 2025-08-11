package DSA.Bucket2._01_arrays._01_arrays;

public class _22_01_BuySellStock_OnlyOnce {

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
