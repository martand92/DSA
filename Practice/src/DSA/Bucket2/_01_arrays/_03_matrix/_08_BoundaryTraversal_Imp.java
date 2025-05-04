package DSA.Bucket2._01_arrays._03_matrix;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/boundary-traversal-of-matrix-1587115620/1
public class _08_BoundaryTraversal_Imp {

	public static void main(String[] args) {

		// int[][] matrix = { { 1 } };
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int i = 0, j = 0, n = matrix.length, m = matrix[0].length;

		ArrayList<Integer> al = new ArrayList<Integer>();

		if (matrix.length == 1 && matrix[0].length == 1)
			al.add(matrix[0][0]);

		else {
			for (j = 0; j < m - 1; j++) // traverse till last - 1 column as in next iteration j++ happens
				al.add(matrix[i][j]);

			for (i = 0; i < n - 1; i++) // traverse till last - 1 row as in next iteration i++ happens
				al.add(matrix[i][j]);

			for (j = m - 1; j > 0; j--) {
				al.add(matrix[i][j]);
				if (matrix.length == 1) // if matrix contains single row then traverse through that row till j - 1
					break;
			}

			for (i = n - 1; i > 0; i--) {
				al.add(matrix[i][j]);
				if (matrix[0].length == 1) // if matrix contains single column then traverse through it till i - 1
					break;
			}
		}

		System.out.println(al);

	}
}
