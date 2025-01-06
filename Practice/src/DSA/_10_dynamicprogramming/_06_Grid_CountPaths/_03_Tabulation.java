package DSA._10_dynamicprogramming._06_Grid_CountPaths;

import java.util.Arrays;

public class _03_Tabulation {

	public static int countPaths(int[][] matrix, int m, int n, int[][] dp) {

		for (int i = 0; i <= m; i++) {

			for (int j = 0; j <= n; j++) {

				int left = 0, right = 0;

				if (i == 0 && j == 0)
					dp[i][j] = 1;

				else {

					if (i > 0)
						left = dp[i - 1][j];

					if (j > 0)
						right = dp[i][j - 1];

					dp[i][j] = left + right;
				}
			}
		}

		return dp[m][n];

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int rows = 0; rows < matrix.length; rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(countPaths(matrix, matrix.length - 1, matrix[0].length - 1, dp));
	}

}