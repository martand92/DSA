package DSA.Bucket2._01_arrays._03_matrix;

//https://practice.geeksforgeeks.org/problems/sums-of-i-th-row-and-i-th-column3054/1
public class _18_SumOf_ith_Row_Col {
	static int r = 0;

	public static void main(String[] args) {

		// int A[][] = { { 1, 2 }, { 2, 1 } };
		// int A[][] = { { 1, 2, 3 }, { 2, 3, 3 } }; // 2 * 3

		int A[][] = { { 5 }, { 0 }, { 0 } };

		int rowSum = 0, colSum = 0, i = 0, j = 0, rowNo = 0, colNo = 0;
		boolean equal = true;

		// loop till last row and last column of the matrix
		outerloop: while (rowNo < A.length && colNo < A[0].length) {

			i = 0;
			j = 0;

			// looping through 1st row by fixing row number as 1
			while (j < A[0].length) {
				rowSum += A[rowNo][j];
				j++;
			}

			// looping through 1st col by fixing column number as 1
			while (i < A.length) {
				colSum += A[i][colNo];
				i++;
			}

			// If given rowSum != colSum then stop
			if (rowSum != colSum) {
				equal = false;
				break outerloop;
			}

			rowNo++;
			colNo++;

		}

		System.out.println(equal);

	}
}
