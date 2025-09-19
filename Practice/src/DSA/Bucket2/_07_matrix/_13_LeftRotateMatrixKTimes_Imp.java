package DSA.Bucket2._07_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/left-rotate-matrix-k-times2351/1
public class _13_LeftRotateMatrixKTimes_Imp {
	static int r = 0;

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 1; // rotate matrix by 1 time to left

		int[][] res = new int[arr.length][arr[0].length];

		k %= arr[0].length; // if need to rotate more than no of columns then reduce to no of columns

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int t = (k + j) % (arr[0].length);
				res[i][j] = arr[i][t];
			}
		}

		System.out.println(Arrays.deepToString(res));
	}
}