package DSA._10_dynamicprogramming._05_NinjaTraining;

public class _01_01_Recursion {

	public static int maxPoints(int[][] training, int row, int col) {
		if (col < 0)
			return 0;

		if (row == 0)
			return training[row][col];

		int max = Integer.MIN_VALUE;
		for (int currentCol = 0; currentCol < training[0].length; currentCol++) {
			if (currentCol != col)
				max = Math.max(max, maxPoints(training, row - 1, currentCol) + training[row][col]);
		}

		return Math.max(max, maxPoints(training, row, col - 1));
	}

	public static void main(String[] args) {

		int[][] training = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };

//		int max = Integer.MIN_VALUE;
//		for (int col = training[0].length - 1; col >= 0; col--)
//			max = Math.max(max, maxPoints(training, training.length - 1, col));

		System.out.println(maxPoints(training, training.length - 1, training[0].length - 1));

	}

}