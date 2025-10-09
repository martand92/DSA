package DSA.Bucket2._07_matrix;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/print-diagonally4331/1
public class _06_PrintDiagonal_Imp {

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		ArrayList<Integer> al = new ArrayList<Integer>();

		// Traverse through 1st row
		for (int j = 0; j < a[0].length; j++) {

			int row = 0, col = j;

			while (col >= 0) {
				al.add(a[row][col]);
				row++;
				col--;
			}
		}

		// Once col traversal is completed, then start row traversal
		for (int i = 1; i < a.length; i++) {

			int row = i, col = a[0].length - 1;

			while (row < a.length) {
				al.add(a[row][col]);
				row++;
				col--;
			}
		}

		System.out.println(al);

	}
}
