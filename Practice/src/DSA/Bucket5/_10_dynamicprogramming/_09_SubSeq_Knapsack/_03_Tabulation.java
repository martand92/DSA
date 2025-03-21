package DSA.Bucket5._10_dynamicprogramming._09_SubSeq_Knapsack;

public class _03_Tabulation {

	public static int maxValue(int[] itemWeights, int[] itemValues, int bagWeight, int[][] dp) {

		for (int index = 0; index < itemValues.length; index++)
			dp[index][0] = 0;

		for (int weight = 0; weight <= bagWeight; weight++) {
			if (weight >= itemWeights[0])
				dp[0][weight] = itemValues[0];
		}

		for (int index = 1; index < itemWeights.length; index++) {

			for (int weight = 1; weight <= bagWeight; weight++) {// starting with 1 as 0 is already calculated in line#8

				int pick = Integer.MIN_VALUE;
				if (weight >= itemWeights[index])
					pick = dp[index - 1][weight - itemWeights[index]] + itemValues[index];

				int notPick = dp[index - 1][weight];

				dp[index][weight] = Math.max(pick, notPick);
			}
		}

		return dp[itemWeights.length - 1][bagWeight];

	}

	public static void main(String[] args) {
		int[] itemWeights = { 1, 2, 4, 5 };
		int[] itemValues = { 5, 4, 8, 6 };

		int bagWeight = 5;

		// as dp[][] runs from index 0->n-1(3) & weight varies between 0->bagWeight(5)
		int[][] dp = new int[itemValues.length][bagWeight + 1];

		System.out.println(maxValue(itemWeights, itemValues, bagWeight, dp));
	}

}
