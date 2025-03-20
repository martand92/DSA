package DSA.Bucket5._10_dynamicprogramming._07_MaxSumPath;

import java.util.Arrays;

public class _04_SpaceOptimization_Incomp {

	public static int[][] findMaxSumPath(int[][] matrix, int[][] dp) {

		dp[0][0] = matrix[0][0];
		dp[0][1] = matrix[0][1];
		dp[0][2] = matrix[0][2];
		dp[0][3] = matrix[0][3];

		for (int n = 1; n < matrix.length; n++) {
			for (int m = 0; m < matrix[0].length; m++) {

				int diagonallyLeft = 0;
				int center = 0;
				int diagonallyRight = 0;

				if (m < matrix[0].length - 1)
					diagonallyLeft = matrix[n][m] + dp[n - 1][m + 1];

				center = matrix[n][m] + dp[n - 1][m];

				if (m > 0)
					diagonallyRight = matrix[n][m] + dp[n - 1][m - 1];

				dp[n][m] = Math.max(diagonallyLeft, diagonallyRight);
				dp[n][m] = Math.max(center, dp[n][m]);
			}
		}

		return dp;
	}

	public static void main(String[] args) {
		int n = 3, m = 3;
		int maxSum = Integer.MIN_VALUE;
		int[][] matrix = new int[][] { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
		int[][] dp = new int[n + 1][m + 1];
		for (int row = 0; row < matrix.length; row++)
			Arrays.fill(dp[row], -1);

		dp = findMaxSumPath(matrix, dp);
		for (int col = 0; col < dp.length; col++)
			maxSum = Math.max(maxSum, dp[matrix.length - 1][col]);

		System.out.println(maxSum);
	}

}
