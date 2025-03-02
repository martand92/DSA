package DSA.Bucket4._10_dynamicprogramming._23_PartitionDP_MatrixChainMultiplication;

public class _02_Memoisation {

	public static int minOperations(int[] arr, int i, int j, int[][] dp) {

		if (i == j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int minNoOperations = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) { // O(N)

			int currentPartitionOps = arr[i - 1] * arr[k] * arr[j];
			int left = minOperations(arr, i, k, dp); // O(N)
			int right = minOperations(arr, k + 1, j, dp); // O(N)

			int totalOps = currentPartitionOps + left + right;

			minNoOperations = Math.min(minNoOperations, totalOps);
		}

		return dp[i][j] = minNoOperations;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };

		int[][] dp = new int[arr.length][arr.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++)
				dp[i][j] = -1;
		}

		System.out.println(minOperations(arr, 1, arr.length - 1, dp));

	}

}

//TC : O(N) * O(N) * O(N) = O(N^3)
//SC : O(N^2) + O(N)