package DSA.Bucket4._10_dynamicprogramming._05_NinjaTraining;

public class _01_00_Recursion {

	public static int maxPoints(int[][] training, int row, int col) {

		if (row == 0)
			return training[row][col];

		int path1 = 0, path2 = 0, path3 = 0;

		if (col != 0)
			path1 = maxPoints(training, row - 1, 0) + training[row][col];

		if (col != 1)
			path2 = maxPoints(training, row - 1, 1) + training[row][col];

		if (col != 2)
			path3 = maxPoints(training, row - 1, 2) + training[row][col];

		return Math.max(path1, Math.max(path2, path3));
	}

	public static void main(String[] args) {

		// int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int[][] training = { { 94, 85, 49 }, { 14, 63, 1 }, { 35, 6, 80 }, { 2, 65, 11 }, { 94, 92, 47 },
				{ 99, 97, 51 } };
		int max = 0;

		for (int col = 2; col >= 0; col--)// iterating through number of columns in last row.
			max = Math.max(max, maxPoints(training, training.length - 1, col));

		System.out.println(max);

	}

}
