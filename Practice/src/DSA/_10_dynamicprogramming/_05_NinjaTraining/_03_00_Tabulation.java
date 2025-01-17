package DSA._10_dynamicprogramming._05_NinjaTraining;

public class _03_00_Tabulation {

	public static int maxPoints(int[][] training, int row, int col) {

		int[][] dp = new int[training.length][3];

		dp[0][0] = training[0][0];
		dp[0][1] = training[0][1];
		dp[0][2] = training[0][2];

		for (int i = 1; i < training.length; i++) {

			int left = 0, right = 0;

			for (int j = 0; j < 3; j++) {

				if (j == 0) {
					left = dp[i - 1][1] + training[i][j];
					right = dp[i - 1][2] + training[i][j];
				}

				dp[i][j] = Math.max(left, right);
			}
		}
		return dp[training.length - 1][2];

	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int max = Integer.MIN_VALUE;

		for (int i = 2; i >= 0; i--)// iterating through number of columns in last row.
			max = Math.max(max, maxPoints(training, training.length - 1, 2));

		System.out.println(max);

	}

}
