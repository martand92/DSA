package DSA.Bucket2._05_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/c-matrix-rotation-by-180-degree0745/1
public class _03_Rotate_180_Degree {

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int temp = 0;

		for (int i = 0; i < a.length / 2; i++) {
			for (int j = 0; j < a[0].length; j++) {
				temp = a[i][j];
				a[i][j] = a[a.length - i - 1][j];
				a[a.length - i - 1][j] = temp;
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length / 2; j++) {
				temp = a[i][j];
				a[i][j] = a[i][a[0].length - 1 - j];
				a[i][a[0].length - 1 - j] = temp;
			}
		}

		System.out.println(Arrays.deepToString(a));

	}
}
