package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1
public class _15_02_MaxOnes_NplusM_Imp {

	public static int rowWithMaxOnes(int[][] matrix) {

		int row = 0, col = matrix[0].length - 1, rowNo = -1;

		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] == 1) {
				col--;
				rowNo = row;
			} else
				row++;
		}

		return rowNo;

		// here worst case you travel all the columns of 1st row and then all the rows
		// of 1st col

		// O(N+M)
	}

	public static void main(String[] args) {

		// int[][] matrix = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };
		int[][] matrix = { { 0, 1 }, { 1, 1 } };

		System.out.println(rowWithMaxOnes(matrix));
	}
}
