package DSA.Bucket4._10_dynamicprogramming._05_NinjaTraining;

public class _03_00_Tabulation {

	public static int maxPoints(int[][] training, int col) {

		int[][] dp = new int[training.length][3];

		for (int j = 0; j < 3; j++)
			dp[0][j] = training[0][j];

		for (int i = 1; i < training.length; i++) {

			for (int j = 0; j < 3; j++) {

				int path1 = 0, path2 = 0, path3 = 0;

				if (j != 0)
					path1 = dp[i - 1][0] + training[i][j];

				if (j != 1)
					path2 = dp[i - 1][1] + training[i][j];

				if (j != 2)
					path3 = dp[i - 1][2] + training[i][j];

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

		for (int col = 2; col >= 0; col--)
			max = Math.max(max, maxPoints(training, col));

		System.out.println(max);

	}

}
