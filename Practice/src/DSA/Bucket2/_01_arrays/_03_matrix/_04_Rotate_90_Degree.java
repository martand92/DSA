package DSA.Bucket2._01_arrays._03_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
public class _04_Rotate_90_Degree {

	public static void main(String[] args) {

//		int[][] a = { { 68, 35, 1, 70, 25, 79, 59 }, { 63, 65, 6, 46, 82, 28, 62 }, { 92, 96, 43, 28, 37, 92, 5 },
//				{ 3, 54, 93, 83, 22, 17, 19 }, { 96, 48, 27, 72, 39, 70, 13 }, { 68, 100, 36, 95, 4, 12, 23 },
//				{ 34, 74, 65, 42, 12, 54, 69 } };

		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int temp = 0;

		// first find transpose of the matrix i.e : a[i][j] = a[j][i]
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a[0].length; j++) { // j = i : _02_TransposeOfMatrix
				temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}

		for (int i = 0; i < a[0].length / 2; i++) {
			for (int j = 0; j < a.length; j++) {
				temp = a[i][j];
				a[i][j] = a[a.length - 1 - i][j];
				a[a.length - 1 - i][j] = temp;
			}
		}

		System.out.println(Arrays.deepToString(a));

	}
}
