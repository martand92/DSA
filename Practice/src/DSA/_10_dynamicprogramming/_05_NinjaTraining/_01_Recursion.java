package DSA._10_dynamicprogramming._05_NinjaTraining;

public class _01_Recursion {

	public static int maxPoints(int[][] training, int row, int col, int prevTask) {

		if (row == 0)
			return training[row][col];

		int left = 0;
		int center = 0;
		int right = 0;

		// As there are 3 choices to be made based on condition
		if (prevTask != 2)
			left = maxPoints(training, row - 1, 2, 2) + training[row][col];

		if (prevTask != 1)
			center = maxPoints(training, row - 1, 1, 1) + training[row][col];

		if (prevTask != 0)
			right = maxPoints(training, row - 1, 0, 0) + training[row][col];

		// Find maximum possible points acquired through training
		int maxTemp = Math.max(left, center);
		return Math.max(maxTemp, right);
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int row = training.length - 1;
		int col = training[0].length - 1;
		int max = Integer.MIN_VALUE;

		for (int prevTask = training.length - 1; prevTask >= 0; prevTask--)// iterating through number of columns in
																			// last row.
			max = Math.max(max, maxPoints(training, row, col, prevTask));// col : 2 -> 0

		System.out.println(max);

	}

}
