package DSA.Bucket2._07_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/rotate-matrix-elements-clockwise2336/1
public class _09_ClockWiseRotate_OnlyOuterEle_Imp {

	public static void main(String[] args) {

		// int[][] Mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
		// 15, 16 } };
		int[][] Mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

//		int[][] Mat = { { 1, 2, 3, 4, 5 } };

		int curr = Mat[0][0], nxt = 0, i = 0, j = 0;

		if (Mat.length == 1 || Mat[0].length == 1) {
			System.out.println(Arrays.deepToString(Mat));
			return;
		}

		for (j = 1; j < Mat[0].length; j++) {
			nxt = Mat[i][j];
			Mat[i][j] = curr;
			curr = nxt;
		}

		j--; // as j = Mat[0].length, need to reduce by 1 to get back to last index
		for (i = 1; i < Mat.length; i++) {
			nxt = Mat[i][j];
			Mat[i][j] = curr;
			curr = nxt;
		}

		i--;
		for (j--; j >= 0; j--) { // initially doing j-- as it crossed boundary
			nxt = Mat[i][j];
			Mat[i][j] = curr;
			curr = nxt;
		}

		j++;
		for (i--; i >= 0; i--) { // initially doing i-- as it crossed boundary
			nxt = Mat[i][j];
			Mat[i][j] = curr;
			curr = nxt;
		}

		System.out.println(Arrays.deepToString(Mat));

	}
}
