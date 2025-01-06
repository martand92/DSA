package DSA._10_dynamicprogramming._06_Grid_CountPaths;

import java.util.Arrays;

public class _02_Memoisation {

	public static int countPaths(int[][] matrix, int m, int n, int[][] dp) {

		if (n == -1 || m == -1)
			return 0;

		if (n == 0 && m == 0)
			return 1;

		if (dp[m][n] != -1)
			return dp[m][n];

		int left = countPaths(matrix, m - 1, n, dp);
		int right = countPaths(matrix, m, n - 1, dp);
		return dp[m][n] = left + right;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int rows = 0; rows < matrix.length; rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(countPaths(matrix, matrix.length - 1, matrix[0].length - 1, dp));
	}

}