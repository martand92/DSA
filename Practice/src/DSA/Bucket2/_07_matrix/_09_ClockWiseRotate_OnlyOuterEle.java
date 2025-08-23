package DSA.Bucket2._07_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/rotate-matrix-elements-clockwise2336/1
public class _09_ClockWiseRotate_OnlyOuterEle {

	public static void main(String[] args) {

		// int[][] Mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
		// 15, 16 } };
		 int[][] Mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

//		int[][] Mat = { { 1, 2, 3, 4, 5 } };

		int curr = 0, nxt = 0;
		int i = 0, j = 0;

		curr = Mat[i][j];

		if (Mat.length == 1 || Mat[0].length == 1) {
			System.out.println(Arrays.deepToString(Mat));
			return;
		}

		for (j = 1; j < Mat[0].length; j++) {
			nxt = curr;
			curr = Mat[i][j];
			Mat[i][j] = nxt;
		}

		// as j = Mat[0].length, need to reduce by 1 to get back to last index
		j--;

		for (i = 1; i < Mat.length; i++) {
			nxt = curr;
			curr = Mat[i][j];
			Mat[i][j] = nxt;
		}

		i--;

		for (j--; j >= 0; j--) { // initially reducing j (j--) as in previous loop it had crossed boundary
			nxt = curr;
			curr = Mat[i][j];
			Mat[i][j] = nxt;
		}

		j++;

		for (i--; i >= 0; i--) {// initially reducing i (i--) as in previous loop it had crossed boundary
			nxt = curr;
			curr = Mat[i][j];
			Mat[i][j] = nxt;
		}

		System.out.println(Arrays.deepToString(Mat));

	}
}
