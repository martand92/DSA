package DSA._10_dynamicprogramming._05_NinjaTraining;

public class _01_00_Recursion {

	public static int maxPoints(int[][] training, int row, int col) {

		if (row == 0)
			return training[row][col];

		int left = 0, right = 0;

		if (col == 2) {
			left = maxPoints(training, row - 1, 0) + training[row][col];
			right = maxPoints(training, row - 1, 1) + training[row][col];
		}

		if (col == 1) {
			left = maxPoints(training, row - 1, 0) + training[row][col];
			right = maxPoints(training, row - 1, 2) + training[row][col];
		}

		if (col == 0) {
			left = maxPoints(training, row - 1, 1) + training[row][col];
			right = maxPoints(training, row - 1, 2) + training[row][col];
		}

		return Math.max(left, right);
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int max = 0;

		for (int col = 2; col >= 0; col--)// iterating through number of columns in last row.
			max = Math.max(max, maxPoints(training, training.length - 1, col));

		System.out.println(max);

	}

}
