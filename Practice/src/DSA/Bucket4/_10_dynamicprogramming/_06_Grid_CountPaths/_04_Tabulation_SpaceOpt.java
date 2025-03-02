package DSA.Bucket4._10_dynamicprogramming._06_Grid_CountPaths;

import java.util.Arrays;

public class _04_Tabulation_SpaceOpt {

	public static int countPaths(int[][] matrix, int m, int n, int[] dp) {

		for (int i = 0; i <= m; i++) {

			int[] temp = new int[n + 1];

			for (int j = 0; j <= n; j++) {

				int left = 0, right = 0;

				if (i == 0 && j == 0)
					temp[j] = 1;

				else {

					if (i > 0)
						left = dp[j];

					if (j > 0)
						right = temp[j - 1];

					temp[j] = left + right;
				}
			}
			
			dp = temp;
		}

		return dp[n];

	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };

		int[] dp = new int[matrix[0].length];
		Arrays.fill(dp, 0);

		System.out.println(countPaths(matrix, matrix.length - 1, matrix[0].length - 1, dp));
	}

}