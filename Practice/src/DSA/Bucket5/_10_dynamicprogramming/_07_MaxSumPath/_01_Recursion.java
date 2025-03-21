package DSA.Bucket5._10_dynamicprogramming._07_MaxSumPath;

public class _01_Recursion {

	public static int findMaxSumPath(int[][] matrix, int n, int m) {

		if (n == 0)
			return matrix[n][m];

		int left = 0, right = 0, center = 0;

		if (m < matrix[0].length - 1)
			left = findMaxSumPath(matrix, n - 1, m + 1) + matrix[n][m];

		center = findMaxSumPath(matrix, n - 1, m) + matrix[n][m];

		if (m > 0)
			right = findMaxSumPath(matrix, n - 1, m - 1) + matrix[n][m];

		return Math.max(Math.max(left, right), center);
	}

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };

		int n = matrix.length - 1, m = matrix[0].length - 1;
		int maxSum = 0;

		for (int col = m; col >= 0; col--)
			maxSum = Math.max(maxSum, findMaxSumPath(matrix, n, col));

		System.out.println(maxSum);
	}

}
