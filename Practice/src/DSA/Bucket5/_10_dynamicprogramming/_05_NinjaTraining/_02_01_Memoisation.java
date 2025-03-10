package DSA.Bucket5._10_dynamicprogramming._05_NinjaTraining;

import java.util.Arrays;

public class _02_01_Memoisation {

	public static int maxPoints(int[][] training, int row, int col, int[][] dp) {

		if (col < 0)
			return 0;

		if (row == 0)
			return training[row][col];

		int max = Integer.MIN_VALUE;

		for (int currentCol = 0; currentCol < training[0].length; currentCol++) {

			if (currentCol != col) {
				if (dp[row][currentCol] != -1)
					return dp[row][currentCol];

				max = Math.max(max, maxPoints(training, row - 1, currentCol, dp) + training[row][col]);
			}
		}

		dp[row][col] = max;

		return Math.max(dp[row][col], maxPoints(training, row, col - 1, dp));
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int[][] dp = new int[training.length][training[0].length];
		for (int row = 0; row < dp.length; row++)
			Arrays.fill(dp[row], -1);

//		int max = Integer.MIN_VALUE;
//		for (int col = training[0].length - 1; col >= 0; col--)
//			max = Math.max(max, maxPoints(training, training.length - 1, col, dp));

		System.out.println(maxPoints(training, training.length - 1, training[0].length - 1, dp));

	}

}