package DSA.Bucket4._10_dynamicprogramming._09_SubSeq_Knapsack;

import java.util.Arrays;

public class _02_Memoisation {

	public static int maxValue(int[] itemWeights, int[] itemValues, int index, int bagWeight, int[][] dp) {

		if (bagWeight == 0)
			return 0;

		if (index == 0 && bagWeight >= itemWeights[index])
			return itemValues[index];

		if (dp[index][bagWeight] != -1)
			return dp[index][bagWeight];

		int pick = Integer.MIN_VALUE;

		if (bagWeight >= itemWeights[index])
			pick = maxValue(itemWeights, itemValues, index - 1, bagWeight - itemWeights[index], dp) + itemValues[index];

		int notPick = maxValue(itemWeights, itemValues, index - 1, bagWeight, dp);

		dp[index][bagWeight] = Math.max(pick, notPick);
		return dp[index][bagWeight];

	}

	public static void main(String[] args) {
		int[] itemWeights = { 1, 2, 4, 5 };
		int[] itemValues = { 5, 4, 8, 6 };

		int n = itemValues.length - 1, bagWeight = 5;

		// as dp[][] runs from index 0->n-1 & weight varies between 0->5(bagWeight)
		int[][] dp = new int[itemValues.length][bagWeight + 1];
		for (int rows = 0; rows < itemWeights.length; rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(maxValue(itemWeights, itemValues, n, bagWeight, dp));
	}

}
