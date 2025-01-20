package DSA._10_dynamicprogramming._05_NinjaTraining;

public class _03_00_Tabulation_Incomp {

	public static int maxPoints(int[][] training, int row, int col) {

		int[][] dp = new int[training.length][3];

		for (int i = 0; i < 3; i++)
			dp[0][i] = training[0][i];

		for (int i = 1; i < dp.length; i++) {

			int left = 0, right = 0;

			for (int j = 0; j < 3; j++) {

				if (j == col)
					continue;

				if (j == 0) {
					left = dp[i - 1][1] + training[i][j];
					right = dp[i - 1][2] + training[i][j];
				}

				if (j == 1) {
					left = dp[i - 1][0] + training[i][j];
					right = dp[i - 1][2] + training[i][j];
				}

				if (j == 2) {
					left = dp[i - 1][0] + training[i][j];
					right = dp[i - 1][1] + training[i][j];
				}

				dp[i][j] = Math.max(left, right);
			}

		}

		return dp[training.length - 1][col];

	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int max = 0;

		for (int col = 2; col >= 0; col--)// iterating through number of columns in last row.
			max = Math.max(max, maxPoints(training, training.length - 1, col));

		System.out.println(max);

	}

}
