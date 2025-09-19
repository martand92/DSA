package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/determinant-of-a-matrix-1587115620/1
public class _27_DeterminantOfMatrix_Incomp {

	static int ans = 0;
	static boolean positive = true;
	static int finalans = 0;

	static int[][] findMatrix(int[][] matrix, int col) {

		int[][] newMatrix = new int[matrix.length - 1][matrix[0].length - 1];

		for (int i = 1; i < matrix.length; i++) {

			int colIndex = 0;

			for (int j = 0; j < matrix.length; j++) {

				if (j != col) {
					newMatrix[i - 1][colIndex] = matrix[i][j];
					colIndex++;
				}

			}
		}

		return newMatrix;

	}

	static int findDeterminant(int[][] matrix, int j) {
		if (matrix.length == 1 && matrix[0].length == 1)
			return matrix[0][0];

		if (matrix.length == 2 && matrix[0].length == 2)
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

		if (matrix.length == 3 && matrix[0].length == 3) {

			int a = matrix[0][0] * findDeterminant(findMatrix(matrix, 0), j)
					- matrix[0][1] * findDeterminant(findMatrix(matrix, 1), j)
					+ matrix[0][2] * findDeterminant(findMatrix(matrix, 2), j);

			return a;

		}

		for (int k = 0; k < matrix[0].length; k++) {

			if (k % 2 != 0)
				ans -= matrix[0][k] * findDeterminant(findMatrix(matrix, k), k);

			else
				ans += matrix[0][k] * findDeterminant(findMatrix(matrix, k), k);

		}
		
		return ans;

	}

	public static void main(String[] args) throws Exception {
		// int[][] matrix = { { 4, 0, 2, 1 }, { 3, 5, 7, 1 }, { 8, 1, 6, 1 }, { 3, 1, 5,
		// 2 } };
		int[][] matrix = { { 5, 4, 0, 2, 1 }, { 5, 3, 5, 7, 1 }, { 5, 8, 1, 6, 1 }, { 5, 3, 1, 5, 2 },
				{ 1, 1, 1, 1, 1 } };
		// int[][] matrix = { { 5, 7, 1 }, { 1, 6, 1 }, { 1, 5, 2 } };
		// int[][] matrix = { { 6, 1 }, { 5, 2 } };
		// int det = findDeterminant(matrix);

		findDeterminant(matrix, 0);
		System.out.println(finalans);

		// System.out.println(a);

//		int b = 0;
//		int c = 0;
//
//		for (int j = 0; j < matrix[0].length; j++) {
//
//			if (j % 2 != 0) {
//				c = findDeterminant(matrix, j);
//				b -= c;
//
//			} else {
//				c = findDeterminant(matrix, j);
//				b += c;
//
//			}
//			System.out.println(c);
//			System.out.println(b);
//		}

		// System.out.println(findDeterminant(matrix, j));

	}
}
