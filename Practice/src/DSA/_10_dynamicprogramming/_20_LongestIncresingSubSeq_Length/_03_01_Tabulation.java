package DSA._10_dynamicprogramming._20_LongestIncresingSubSeq_Length;

public class _03_01_Tabulation {

	public static int longestIncreasingSubSeq(int[] arr, int[][] dp) {

		// below code is not needed as by default value is already set to 0
		for (int j = 0; j <= arr.length; j++)
			dp[arr.length][j] = 0;

		for (int index = arr.length - 1; index >= 0; index--) {

			for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {// prevIndex has to start from index - 1 as
																			// its previous to index

				int pick = 0;

				if (prevIndex == -1 || (arr[prevIndex] - arr[index] < 0))
					pick = 1 + dp[index + 1][index + 1]; // second param is +1 as prevIndex would have -1

				int notPick = dp[index + 1][prevIndex + 1]; // second param is +1 as prevIndex will loop upto -1

				dp[index][prevIndex + 1] = Math.max(pick, notPick);
			}
		}

		return dp[0][0];

	}

	public static void main(String[] args) {

		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };

		// index and prevIndex are variables and in recursion prevIndex has -1. To
		// accommodate this -1, need to remap prevIndex from 0 -> n+1
		int[][] dp = new int[arr.length + 1][arr.length + 1];

		System.out.println(longestIncreasingSubSeq(arr, dp));
	}

}

//TC : O(n * n)
//SC : O(n * n)