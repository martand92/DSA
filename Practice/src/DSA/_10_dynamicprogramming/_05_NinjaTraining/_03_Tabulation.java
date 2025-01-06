package DSA._10_dynamicprogramming._05_NinjaTraining;

import java.util.Arrays;

public class _03_Tabulation {

	public static int[][] maxPoints(int[][] training, int[][] dp) {

		dp[0][0] = training[0][0];
		dp[0][1] = training[0][1];
		dp[0][2] = training[0][2];

		for (int n = 1; n < dp.length; n++) {

			for (int prevTask = 2; prevTask >= 0; prevTask--) {

				if (prevTask == 2)
					dp[n][prevTask] = Math.max(dp[n - 1][0], dp[n - 1][1]) + training[n][prevTask];
				if (prevTask == 1)
					dp[n][prevTask] = Math.max(dp[n - 1][0], dp[n - 1][2]) + training[n][prevTask];
				if (prevTask == 0)
					dp[n][prevTask] = Math.max(dp[n - 1][1], dp[n - 1][2]) + training[n][prevTask];
			}
		}
		return dp;
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int[][] dp = new int[training.length][training[0].length];

		for (int rows = 0; rows < dp.length; rows++)
			Arrays.fill(dp[rows], -1);

		dp = maxPoints(training, dp);

		int max = Integer.MIN_VALUE;
		for (int col = 0; col < dp[0].length; col++)
			max = Math.max(max, dp[training.length - 1][col]);
		
		System.out.println(max);
	}

}
