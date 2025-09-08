package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1
public class _15_01_MaxOnes_NLogM_Imp {

	public static void main(String[] args) {

		// int[][] matrix = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };
		int[][] matrix = { { 0, 1 }, { 1, 1 } };

		int i = 0, count = 0, rowNo = 0, index = 0;

		for (i = 0; i < matrix.length; i++) {

			int l = 0, r = matrix[0].length - 1;
			int mid = ((l + r) / 2);
			
			
			//here l and r converges onto first occurrence of 1 in given row
			while (l <= r) {

				if (matrix[i][mid] == 1) {
					index = mid;
					r = mid - 1;

				} else
					l = mid + 1;

				mid = (l + r) / 2;
			}

			if ((matrix[0].length - index) > count) {
				count = matrix[0].length - index;
				rowNo = i;
			}

		}

		System.out.println(rowNo);

	}
}
