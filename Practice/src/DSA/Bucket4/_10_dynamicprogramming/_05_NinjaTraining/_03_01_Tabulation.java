package DSA.Bucket4._10_dynamicprogramming._05_NinjaTraining;

public class _03_01_Tabulation {

	public static int maxPoints(int[][] training, int[][] dp) {

//		if (row == 0)
//			return training[row][col];

		for (int col = 0; col < 3; col++)
			dp[0][col] = training[0][col];

		for (int row = 1; row < training.length; row++) {

			for (int col = 0; col < training[0].length; col++) {

				int max = Integer.MIN_VALUE;

				for (int currentCol = 0; currentCol < training[0].length; currentCol++) {
					if (col != currentCol)
						max = Math.max(max, dp[row - 1][currentCol] + training[row][col]);
				}

				dp[row][col] = max;
			}
		}

		return dp[training.length - 1][training[0].length - 1];
	}

	public static void main(String[] args) {

		// int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };

		int[][] training = { { 94, 85, 49 }, { 14, 63, 1 }, { 35, 6, 80 }, { 2, 65, 11 }, { 94, 92, 47 },
				{ 99, 97, 51 } };
		int[][] dp = new int[training.length][training[0].length];

		System.out.println(maxPoints(training, dp));

	}

}