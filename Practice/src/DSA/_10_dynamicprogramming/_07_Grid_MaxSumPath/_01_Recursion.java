package DSA._10_dynamicprogramming._07_Grid_MaxSumPath;

public class _01_Recursion {

	public static int findMaxSumPath(int[][] matrix, int n, int m, int maxSum) {

		if (n == 0)
			return matrix[n][m];

		int diagonallyLeft = 0;
		int diagonallyRight = 0;
		int center = 0;

		if (m + 1 < matrix.length)
			diagonallyLeft = matrix[n][m] + findMaxSumPath(matrix, n - 1, m + 1, maxSum);

		center = matrix[n][m] + findMaxSumPath(matrix, n - 1, m, maxSum);

		if (m - 1 >= 0)
			diagonallyRight = matrix[n][m] + findMaxSumPath(matrix, n - 1, m - 1, maxSum);

		return Math.max(Math.max(diagonallyLeft, diagonallyRight), center);
	}

	public static void main(String[] args) {
		int n = 3, m = 3;
		int[][] matrix = new int[][] { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };
		int maxSum = Integer.MIN_VALUE;

		for (int i = m; i >= 0; i--)
			maxSum = Math.max(maxSum, findMaxSumPath(matrix, n, i, 0));

		System.out.println(maxSum);
	}

}
