package DSA.Bucket2._01_arrays._03_matrix;

import java.util.ArrayList;
import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/make-zeroes4042/1
public class _24_MakeZeroes {

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int[][] makeZeros_Brute(int[][] matrix) {
		int sum = 0;
		int[][] ans = new int[matrix.length][matrix[0].length];// O(n * m)

		for (int i = 0; i < matrix.length; i++) { // O(n * m)
			for (int j = 0; j < matrix[0].length; j++) {
				ans[i][j] = matrix[i][j];
			}
		}

		for (int i = 0; i < matrix.length; i++) { // O(n * m)
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {
					if (i - 1 >= 0) {
						sum += matrix[i - 1][j];
						ans[i - 1][j] = 0;
					}
					if (j - 1 >= 0) {
						sum += matrix[i][j - 1];
						ans[i][j - 1] = 0;
					}
					if (j + 1 <= matrix[0].length - 1) {
						sum += matrix[i][j + 1];
						ans[i][j + 1] = 0;
					}
					if (i + 1 <= matrix.length - 1) {
						sum += matrix[i + 1][j];
						ans[i + 1][j] = 0;
					}

					ans[i][j] = sum;
					sum = 0;
				} // O(4) for all 4 side checks
			}
		}

		return ans;

		// TC: O(2 * n * m * 4)
		// SC : O(n * m)
	}

	public static int[][] makeZeros_Opt(int[][] mat) {

		ArrayList<Pair> al = new ArrayList<Pair>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0)
					al.add(new Pair(i, j));
			}
		}

		for (int i = 0; i < al.size(); i++) {

			int row = al.get(i).row;
			int col = al.get(i).col;

			int sum = 0;

			if (row - 1 >= 0)
				sum += mat[row - 1][col];

			if (row + 1 < mat.length)
				sum += mat[row + 1][col];

			if (col - 1 >= 0)
				sum += mat[row][col - 1];

			if (col + 1 < mat[0].length)
				sum += mat[row][col + 1];

			mat[row][col] = sum;
		}

		for (int i = 0; i < al.size(); i++) {

			int row = al.get(i).row;
			int col = al.get(i).col;

			if (row - 1 >= 0)
				mat[row - 1][col] = 0;

			if (row + 1 < mat.length)
				mat[row + 1][col] = 0;

			if (col - 1 >= 0)
				mat[row][col - 1] = 0;

			if (col + 1 < mat[0].length)
				mat[row][col + 1] = 0;
		}

		return mat;

		// TC : O(n*m + no of zeros * 4 + no of zeros * 4)
		// SC : O(no of zeros)
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 0, 7 }, { 8, 9, 4, 6 }, { 8, 4, 5, 2 } };

		System.out.println(Arrays.deepToString(makeZeros_Brute(matrix)));
		System.out.println(Arrays.deepToString(makeZeros_Opt(matrix)));

	}
}
