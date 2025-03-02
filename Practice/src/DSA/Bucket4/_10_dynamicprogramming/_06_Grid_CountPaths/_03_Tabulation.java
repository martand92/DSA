package DSA.Bucket4._10_dynamicprogramming._06_Grid_CountPaths;

public class _03_Tabulation {

	public static int countPaths(int[][] matrix, int m, int n) {

		int[][] dp = new int[m][n];
		dp[0][0] = 1;

		for (int i = 0; i < m; i++) {

			int left = 0, right = 0;

			for (int j = 0; j < n; j++) {

				if (i > 0)
					left = dp[i - 1][j];

				if (j > 0)
					right = dp[i][j - 1];

				// Don't override dp[0][0] which is set as 1
				if (!(i == 0 && j == 0))
					dp[i][j] = left + right;
			}
		}

		return dp[m - 1][n - 1];// ans will be in last row and col
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int m = matrix.length;
		int n = matrix[0].length;

		System.out.println(countPaths(matrix, m, n));
	}

}