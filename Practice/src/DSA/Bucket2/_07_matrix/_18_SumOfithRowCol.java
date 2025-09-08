package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/sums-of-i-th-row-and-i-th-column3054/1
public class _18_SumOfithRowCol {

	public static boolean isSumEqual(int[][] mat) {

		int itr = Math.min(mat.length, mat[0].length);
		int rowSum = 0, colSum = 0;

		for (int i = 0; i < itr; i++) {

			for (int j = 0; j < mat[0].length; j++) {

				rowSum += mat[i][j];

				if (j < mat.length)
					colSum += mat[j][i];
			}

			if (colSum != rowSum)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		// int A[][] = { { 1, 2 }, { 2, 1 } };
		// int A[][] = { { 1, 2, 3 }, { 2, 3, 3 } }; // 2 * 3
		int A[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } }; // 3 * 2
		// int A[][] = { { 5 }, { 0 }, { 0 } };

		System.out.println(isSumEqual(A));
	}
}
