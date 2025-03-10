package DSA.Bucket5._10_dynamicprogramming._07_Grid_MaxSumPath;

public class _03_Tabulation {

	public static int findMaxSumPath(int[][] matrix, int col) {

		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int j = 0; j < dp[0].length; j++)
			dp[0][j] = matrix[0][j];

		for (int i = 1; i < dp.length; i++) {

			int l = 0, c = 0, r = 0;

			for (int j = 0; j < dp[0].length; j++) {

				if (j < matrix[0].length - 1)
					l = dp[i - 1][j + 1] + matrix[i][j];

				c = dp[i - 1][j] + matrix[i][j];

				if (j > 0)
					r = dp[i - 1][j - 1] + matrix[i][j];

				dp[i][j] = Math.max(Math.max(l, r), c);
			}
		}

		return dp[dp.length - 1][col];// as ans will be in last row & resp col of each itr
	}

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };

		int maxSum = 0;

		for (int col = matrix[0].length - 1; col >= 0; col--)
			maxSum = Math.max(maxSum, findMaxSumPath(matrix, col));

		System.out.println(maxSum);
	}

}
