package DSA.Bucket2._05_matrix;

import java.util.*;

//https://www.youtube.com/watch?v=3Zv-s9UUrFM
//https://www.naukri.com/code360/problems/spiral-matrix_6922069

public class _10_02_SpiralTraversal {

	public static List<Integer> spiralTraversal(int[][] mat) {

		List<Integer> al = new ArrayList<Integer>();
		int itr = 0, row = 0, col = 0;

		while (itr <= mat.length / 2) {

			row = itr;
			col = itr;

			while (col < mat[0].length - itr) {
				al.add(mat[row][col]);
				col++;
			}

			col--;
			row++;
			while (row < mat.length - itr) {
				al.add(mat[row][col]);
				row++;
			}

			row--;
			col--;
			while (col >= itr) {
				al.add(mat[row][col]);
				col--;
			}

			col++;
			row--;
			while (row > itr) {
				al.add(mat[row][col]);
				row--;
			}

			itr++;
		}

		return al;

		// TC : O(n * m)
	}

	public static void main(String[] args) {

		// int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println(spiralTraversal(mat));
	}
}
