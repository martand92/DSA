package DSA._10_dynamicprogramming._05_NinjaTraining;

import java.util.Arrays;

public class _02_Memoisation {

	public static int maxPoints(int[][] training, int n, int prevTask, int[][] dp) {

		if (n == 0)
			return training[n][prevTask];

		int left = 0;
		int center = 0;
		int right = 0;

		// As there are 3 choices to be made based on condition

		if (prevTask != 2) {
			if (dp[n][prevTask] != -1)
				return dp[n][prevTask];
			left = maxPoints(training, n - 1, 2, dp) + training[n][prevTask];
		}

		if (prevTask != 1) {
			if (dp[n][prevTask] != -1)
				return dp[n][prevTask];
			center = maxPoints(training, n - 1, 1, dp) + training[n][prevTask];
		}

		if (prevTask != 0) {
			if (dp[n][prevTask] != -1)
				return dp[n][prevTask];
			right = maxPoints(training, n - 1, 0, dp) + +training[n][prevTask];
		}

		// Find maximum possible points acquired through training
		int maxTemp = Math.max(left, center);
		return dp[n][prevTask] = Math.max(maxTemp, right);
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int n = training.length - 1;
		int m = training[0].length - 1;

		int[][] dp = new int[n + 1][m + 1];
		for (int row = 0; row < training.length; row++)
			Arrays.fill(dp[row], -1);

		int max = Integer.MIN_VALUE;
		for (int col = training.length - 1; col >= 0; col--)// iterating through number of columns in last row.
			max = Math.max(max, maxPoints(training, n, col, dp));// col : 2 -> 0

		System.out.println(Arrays.deepToString(dp));
		System.out.println(max);
	}

}
