package DSA._10_dynamicprogramming._05_NinjaTraining;

public class _03_00_Tabulation_Incomp {

	public static int maxPoints(int[][] training, int col, int[][] dp) {

		for (int i = 1; i < training.length; i++) {

			int path1 = 0, path2 = 0, path3 = 0;

			for (int j = 0; j < 3; j++) {

				if (col != j)
					path1 = dp[i - 1][j] + training[i][col];

				if (col != j)
					path2 = dp[i - 1][j] + training[i][col];

				if (col != j)
					path3 = dp[i - 1][j] + training[i][col];

				dp[i][j] = Math.max(path1, Math.max(path2, path3));
			}
		}

		return dp[training.length - 1][col];
	}

	public static void main(String[] args) {

		// int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int[][] training = { { 94, 85, 49 }, { 14, 63, 1 }, { 35, 6, 80 }, { 2, 65, 11 }, { 94, 92, 47 },
				{ 99, 97, 51 } };

		int max = 0;

		int[][] dp = new int[training.length][3];
		for (int j = 0; j < 3; j++)
			dp[0][j] = training[0][j];

		for (int col = 0; col < 3; col++)// As tabulation is reverse of memoisation, reversing this iteration
			max = Math.max(max, maxPoints(training, col, dp));

		System.out.println(max);

	}

}
