package DSA.Bucket2._01_arrays._04_matrix;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/sum-of-upper-and-lower-triangles-1587115621/1
public class _20_SumOfUpperAndLowerTriangles {

	public static void main(String[] args) {

		int[][] matrix = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };
		// int[][] matrix = { { 0, 1 }, { 1, 1 } };

		int sum = 0;
		int i = 0, j = 0;

		ArrayList<Integer> al = new ArrayList<Integer>();
		for (i = 0; i < matrix.length; i++) {
			for (j = i; j < matrix[0].length; j++)
				sum += matrix[i][j];
		}

		al.add(sum);

		sum = 0;
		i = 0;
		j = 0;

		for (i = 0; i < matrix.length; i++) {
			for (j = 0; j <= i; j++)
				sum += matrix[i][j];
		}

		al.add(sum);

		System.out.println(al);

	}
}
