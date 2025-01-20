package DSA._10_dynamicprogramming._07_Grid_MaxSumPath;

public class _03_Tabulation {

	public static int findMaxSumPath(int[][] matrix, int n, int m, int col) {

		int[][] dp = new int[n][m];

		for (int i = 0; i < dp[0].length; i++)
			dp[0][i] = matrix[0][i];

		for (int i = 1; i < dp.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {

				int l = 0, c = 0, r = 0;

				if (j < m - 1)
					l = dp[i - 1][j + 1] + matrix[i][j];

				c = dp[i - 1][j] + matrix[i][j];

				if (j > 0)
					r = dp[i - 1][j - 1] + matrix[i][j];

				dp[i][j] = Math.max(Math.max(l, r), c);
			}
		}

		return dp[n - 1][col];// as ans will be in last row & resp col of each itr
	}

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };

		int n = matrix.length, m = matrix[0].length;
		int maxSum = 0;

		for (int col = m - 1; col >= 0; col--)
			maxSum = Math.max(maxSum, findMaxSumPath(matrix, n, m, col));

		System.out.println(maxSum);
	}

}
