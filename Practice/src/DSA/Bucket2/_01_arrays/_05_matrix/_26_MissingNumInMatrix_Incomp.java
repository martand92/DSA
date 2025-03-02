package DSA.Bucket2._01_arrays._05_matrix;

//https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1?page=2&difficulty[]=0&category[]=Matrix&sortBy=submissions
public class _26_MissingNumInMatrix_Incomp {

	public static void main(String[] args) throws Exception {
		int[][] matrix = { { 4, 0, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
		// int[][] matrix = { { 5, 5 }, { 5, 0 } };
		@SuppressWarnings("unused")
		int sum = 0, foundSum = Integer.MAX_VALUE, zeroi = Integer.MAX_VALUE, zeroj = Integer.MAX_VALUE;
		boolean broke = false;

		// Step 1: first check all rows other than row consisting 0 adds up to same
		// number
		// Step 2: then check all columns other than column consisting 0 adds up to same
		// number as initially found sum
		// Step 3 : Then check both diagonals (except containing 0) adds upto same sum
		// Step 4: if all row , columns, diagonals adds upto to same sum then its
		// possible to replace value of 0 else not possible so return -1

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] != 0)
					sum += matrix[i][j];

				else {
					zeroi = i;
					zeroj = j;
					broke = true;
					break;
				}
			}

			if (!broke) {
				if (foundSum == Integer.MAX_VALUE)
					foundSum = sum;
				else if (foundSum != sum)
					throw new Exception("Cannot replace zero");
			}

			sum = 0;
			broke = false;

		}

		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length; i++) {

				if (matrix[i][j] != 0)
					sum += matrix[i][j];

				else {
					zeroi = i;
					zeroj = j;
					broke = true;
					break;
				}
			}

			if (!broke) {
				if (foundSum == Integer.MAX_VALUE)
					foundSum = sum;
				else if (foundSum != sum)
					throw new Exception("Cannot replace zero");
			}

			sum = 0;
			broke = false;

		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[i][i] != 0)
				sum += matrix[i][i];
			else {
				zeroi = i;
				zeroj = i;
				broke = true;
				break;
			}
		}

		if (!broke && foundSum != sum)
			throw new Exception("Cannot replace zero");

		sum = 0;

		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {

			if (matrix[i][j] != 0)
				sum += matrix[i][j];

			else {
				zeroi = i;
				zeroj = j;
				broke = true;
				break;
			}

			i++;
			j--;
		}

		if (!broke && foundSum != sum)
			throw new Exception("Cannot replace zero");

		sum = 0;

		if (zeroi != Integer.MAX_VALUE) {
			for (j = 0; j < matrix.length; j++)
				foundSum -= matrix[zeroi][j];

		} else
			throw new Exception("Zero not found in matrix");

		System.out.println("Number to replace zero : " + foundSum);

	}
}
