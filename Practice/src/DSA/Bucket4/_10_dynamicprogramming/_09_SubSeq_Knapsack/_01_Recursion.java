package DSA.Bucket4._10_dynamicprogramming._09_SubSeq_Knapsack;

public class _01_Recursion {

	public static int maxValue(int[] itemWeights, int[] itemValues, int index, int bagWeight) {

		if (bagWeight == 0)
			return 0;

		if (index == 0 && bagWeight >= itemWeights[index])
			return itemValues[index];

		int pick = Integer.MIN_VALUE;

		if (bagWeight >= itemWeights[index])
			pick = maxValue(itemWeights, itemValues, index - 1, bagWeight - itemWeights[index]) + itemValues[index];

		int notPick = maxValue(itemWeights, itemValues, index - 1, bagWeight);

		return Math.max(pick, notPick);

	}

	public static void main(String[] args) {
		int[] itemWeights = { 1, 2, 4, 5 };
		int[] itemValues = { 5, 4, 8, 6 };
		
		int n = itemValues.length - 1, bagWeight = 5;

		System.out.println(maxValue(itemWeights, itemValues, n, bagWeight));
	}

}
