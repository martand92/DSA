package DSA._10_dynamicprogramming._05_NinjaTraining;

import java.util.Arrays;

public class _03_01_Tabulation {

	public static int maxPoints(int[][] training, int[][] dp) {

//		if (row == 0)
//			return training[row][col];

		dp[0][0] = training[0][0];
		dp[0][1] = training[0][1];
		dp[0][2] = training[0][2];

		for (int row = 1; row < training.length; row++) {

			for (int col = 0; col < training[0].length; col++) {

				int max = Integer.MIN_VALUE;

				for (int currentCol = 0; currentCol < training[0].length; currentCol++) {
					if (col != currentCol)
						max = Math.max(max, dp[row - 1][currentCol] + training[row][col]);
				}

				dp[row][col] = max;
			}
		}

		return dp[training.length - 1][training[0].length - 1];
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int[][] dp = new int[training.length][training[0].length];
		for (int row = 0; row < dp.length; row++)
			Arrays.fill(dp[row], -1);

		System.out.println(maxPoints(training, dp));

	}

}