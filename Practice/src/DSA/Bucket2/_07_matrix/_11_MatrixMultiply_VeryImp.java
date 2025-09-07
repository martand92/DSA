package DSA.Bucket2._07_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/multiply-matrices/1
public class _11_MatrixMultiply_VeryImp {

	public static void main(String[] args) {

		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] B = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
		int[][] C = new int[A.length][B[0].length]; // Final matrix will have row of first matrix * col of second matrix

		for (int i = 0; i < A.length; i++) {// loop through 1st matrix

			for (int k = 0; k < B[0].length; k++) { // loop through 2nd matrix

				for (int j = 0; j < A[0].length; j++) {

					// C[i][k], i = row of first matrix & k = col of second matrix
					C[i][k] += A[i][j] * B[j][k];
				}
			}
		}

		System.out.println(Arrays.deepToString(C));

	}
}