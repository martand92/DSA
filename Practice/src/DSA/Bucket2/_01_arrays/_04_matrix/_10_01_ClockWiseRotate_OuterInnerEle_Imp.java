package DSA.Bucket2._01_arrays._04_matrix;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/rotate-matrix-elements-clockwise2336/1
public class _10_01_ClockWiseRotate_OuterInnerEle_Imp {

	public static void main(String[] args) {

		int[][] Mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// int[][] Mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};

		// int[][] Mat = { { 1, 2, 3, 4, 5 } };

		int curr = 0, nxt = 0;
		int i = 0, j = 0;
		int row = 0, col = 0;

		if (Mat.length == 1 || Mat[0].length == 1) {
			System.out.println(Mat);
			return;
		}

		while (row < Mat.length / 2 && col < Mat[0].length / 2) {

			curr = Mat[row][col];
			i = row;
			for (j = 1 + col; j < Mat[0].length - col; j++) {
				nxt = curr;
				curr = Mat[i][j];
				Mat[i][j] = nxt;
			}

			j--;

			for (i = 1 + row; i < Mat.length - row; i++) {
				nxt = curr;
				curr = Mat[i][j];
				Mat[i][j] = nxt;
			}

			i--;

			for (j--; j >= col; j--) { // initially reducing j (j--) as in previous loop it had crossed boundary
				nxt = curr;
				curr = Mat[i][j];
				Mat[i][j] = nxt;
			}

			j++;

			for (i--; i >= row; i--) {// initially reducing i (i--) as in previous loop it had crossed boundary
				nxt = curr;
				curr = Mat[i][j];
				Mat[i][j] = nxt;
			}

			row++;
			col++;
		}

		System.out.println(Arrays.deepToString(Mat));

	}
}
