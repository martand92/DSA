package DSA._10_dynamicprogramming._09_SubSeq_Knapsack;

public class _03_Tabulation {

	public static int maxValue(int[] itemWeights, int[] itemValues, int bagWeight, int[][] dp) {

//		if (bagWeight == 0)
//			return 0;
		for (int index = 0; index < itemValues.length; index++)
			dp[index][0] = 0;

//		if (index == 0 && bagWeight >= itemWeights[0])
//			return itemValues[index];
		for (int weight = 0; weight <= bagWeight; weight++) {
			if (weight >= itemWeights[0])
				dp[0][weight] = itemValues[0];
		}

// 		int pick = Integer.MIN_VALUE;		
//		if (bagWeight >= itemWeights[index])
//			pick = maxValue(itemWeights, itemValues, index - 1, bagWeight - itemWeights[index], dp) + itemValues[index];
//
//		int notPick = maxValue(itemWeights, itemValues, index - 1, bagWeight, dp);
//
//		dp[index][bagWeight] = Math.max(pick, notPick);
//		return dp[index][bagWeight];

		for (int index = 1; index < itemWeights.length; index++) {

			for (int weight = 0; weight <= bagWeight; weight++) {

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
