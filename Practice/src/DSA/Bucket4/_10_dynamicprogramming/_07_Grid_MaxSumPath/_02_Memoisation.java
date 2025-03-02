package DSA.Bucket4._10_dynamicprogramming._07_Grid_MaxSumPath;

import java.util.Arrays;

public class _02_Memoisation {

	public static int findMaxSumPath(int[][] matrix, int n, int m, int[][] dp) {

		if (n == 0)
			return matrix[n][m];

		if (dp[n][m] != -1)
			return dp[n][m];

		int left = 0;
		int right = 0;
		int center = 0;

		if (m < matrix[0].length - 1)
			left = findMaxSumPath(matrix, n - 1, m + 1, dp) + matrix[n][m];

		center = findMaxSumPath(matrix, n - 1, m, dp) + matrix[n][m];

		if (m > 0)
			right = findMaxSumPath(matrix, n - 1, m - 1, dp) + matrix[n][m];

		return dp[n][m] = Math.max(Math.max(left, right), center);
	}

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
		int n = matrix[0].length - 1, m = matrix.length - 1;

		int[][] dp = new int[n + 1][m + 1];
		for (int row = 0; row < matrix.length; row++)
			Arrays.fill(dp[row], -1);

		int maxSum = 0;
		for (int col = m; col >= 0; col--)
			maxSum = Math.max(maxSum, findMaxSumPath(matrix, n, col, dp));

		System.out.println(maxSum);
	}

}
