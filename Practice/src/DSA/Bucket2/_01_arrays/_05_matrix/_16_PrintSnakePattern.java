package DSA.Bucket2._01_arrays._05_matrix;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/print-matrix-in-snake-pattern-1587115621/1
public class _16_PrintSnakePattern {

	public static void main(String[] args) {

		// int[][] matrix = { { 1 }, { 2 } };
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		ArrayList<Integer> al = new ArrayList<Integer>();
		int i = 0, j = 0;

		for (i = 0; i < matrix.length; i++) {

			if (i % 2 == 0)
				for (j = 0; j < matrix[0].length; j++)
					al.add(matrix[i][j]);

			else
				for (j--; j >= 0; j--)
					al.add(matrix[i][j]);

		}

		System.out.println(al);

	}
}
