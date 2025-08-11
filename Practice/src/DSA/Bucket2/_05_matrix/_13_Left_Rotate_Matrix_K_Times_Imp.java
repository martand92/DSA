package DSA.Bucket2._05_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/left-rotate-matrix-k-times2351/1
public class _13_Left_Rotate_Matrix_K_Times_Imp {
	static int r = 0;

	public static void main(String[] args) {

		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int N = A.length, M = A[0].length;
		int[][] res = new int[N][M];
		int K = 1; // rotate matrix by 1 time to left

		K %= M; // if need to rotate more than no of columns then reduce to no of columns

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				int t = (K + j) % M;
				res[i][j] = A[i][t]; // here resulted element is picked

			}

		}

		System.out.println(Arrays.deepToString(res));

	}
}
