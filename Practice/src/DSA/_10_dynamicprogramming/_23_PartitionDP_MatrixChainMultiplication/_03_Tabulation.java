package DSA._10_dynamicprogramming._23_PartitionDP_MatrixChainMultiplication;

public class _03_Tabulation {

	public static int minOperations(int[] arr) {

		int[][] dp = new int[arr.length][arr.length];

//		if (i == j)
//			return 0;

		// no need to run below loop as dp[][] is defaulted to 0
		for (int i = 1; i < arr.length; i++)
			dp[i][i] = 0;

//		int minNoOperations = Integer.MAX_VALUE;
//
//		for (int k = i; k < j; k++) { // O(N)
//
//			int currentPartitionOps = arr[i - 1] * arr[k] * arr[j];
//			int left = minOperations(arr, i, k, dp); // O(N)
//			int right = minOperations(arr, k + 1, j, dp); // O(N)
//
//			int totalOps = currentPartitionOps + left + right;
//
//			minNoOperations = Math.min(minNoOperations, totalOps);
//		}
//
//		return dp[i][j] = minNoOperations;

		for (int i = arr.length - 1; i >= 1; i--) {// in recursion i looped from 1 -> n-1
			for (int j = i + 1; j < arr.length; j++) { // in recursion j remained either i or n-1 and looped from n-1 ->
														// i

				int minNoOperations = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {
					int currentPartitionOps = arr[i - 1] * arr[k] * arr[j];
					int left = dp[i][k];
					int right = dp[k + 1][j];
					int totalOps = currentPartitionOps + left + right;

					minNoOperations = Math.min(minNoOperations, totalOps);
				}

				dp[i][j] = minNoOperations;

			}
		}

		return dp[1][arr.length - 1]; // as i moves towards 1 and j move towards n-1

	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };

		System.out.println(minOperations(arr));

	}

}

//TC : O(N) * O(N) * O(N) = O(N^3)
//SC : O(N^2)