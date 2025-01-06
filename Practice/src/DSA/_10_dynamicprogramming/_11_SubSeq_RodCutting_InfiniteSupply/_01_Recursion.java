package DSA._10_dynamicprogramming._11_SubSeq_RodCutting_InfiniteSupply;

public class _01_Recursion {

	public static int maxRodPrice(int n, int[] price, int index) {
		
		if(n == 0)
			return 0;

		if (index == 0) {
			if (n >= index + 1) {
				return n * price[index];
			}
		}

		int pick = Integer.MIN_VALUE;
		if (n >= index + 1)
			pick = maxRodPrice(n - (index + 1), price, index) + price[index];

		int notPick = maxRodPrice(n, price, index - 1);
		return Math.max(pick, notPick);
	}

	public static void main(String[] args) {
		int n = 5;
		int[] price = { 2, 5, 7, 8, 10 };
		System.out.println(maxRodPrice(n, price, price.length - 1));

	}

}
