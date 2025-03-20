package DSA.Bucket5._10_dynamicprogramming._06_CountPaths;

public class _03_02_Tabulation {

	public static int countPaths(int[][] matrix, int m, int n) {

		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = 1;

		for (int i = m - 1; i >= 0; i--) {

			for (int j = n - 1; j >= 0; j--) {

				int left = 0, right = 0;

				if (i + 1 < m)
					left = dp[i + 1][j];

				if (j + 1 < n)
					right = dp[i][j + 1];

				// Don't override dp[0][0] which is set as 1
				if (!(i == m - 1 && j == n - 1))
					dp[i][j] = left + right;
			}
		}

		return dp[0][0];// ans will be in last row and col
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int m = matrix.length;
		int n = matrix[0].length;

		System.out.println(countPaths(matrix, m, n));
	}

}