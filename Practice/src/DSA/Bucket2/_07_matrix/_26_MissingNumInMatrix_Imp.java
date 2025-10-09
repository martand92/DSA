package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1
public class _26_MissingNumInMatrix_Imp {

	// Step 1: first check all rows other than row consisting 0 adds up to same
	// number
	// Step 2: then check all columns other than column consisting 0 adds up to same
	// number as initially found sum
	// Step 3 : Then check both diagonals (except containing 0) adds upto same sum
	// Step 4: if all row , columns, diagonals adds upto to same sum then its
	// possible to replace value of 0 else not possible so return -1

	public static int missingNum(int[][] mat) {

		int zeroi = 0, zeroj = 0, intendedSum = Integer.MIN_VALUE, sum = 0;

		if (mat.length == 1)
			return 1;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					zeroi = i;
					zeroj = j;
				}
			}
		}

		// sum up all rows except for the row with 0 & check if all rows has same sum
		for (int i = 0; i < mat.length; i++) {
			sum = 0;
			if (i != zeroi) {// if current row is same as row containing 0 then skip that row
				for (int j = 0; j < mat[0].length; j++)
					sum += mat[i][j];
			}

			if (intendedSum == Integer.MIN_VALUE)
				intendedSum = sum;
			else if (intendedSum != sum && i != zeroi)
				return -1;
		}

		// sum up all cols except for the col with 0 & check if all cols has same sum
		for (int j = 0; j < mat[0].length; j++) {
			sum = 0;
			if (j != zeroj) {// if current col is same as col containing 0 then skip that col
				for (int i = 0; i < mat.length; i++)
					sum += mat[i][j];
			}

			if (intendedSum != sum && j != zeroj)
				return -1;
		}

		// keep looping through diagonal elements & check if row & col coincide with
		// zeroi & zeroj, then ignore this sum
		sum = 0;
		boolean diagonalZero = false;
		for (int i = 0; i < mat.length; i++) {
			if (i == zeroi && i == zeroj) {
				diagonalZero = true;
				break;
			}
			sum += mat[i][i];
		}
		if (!diagonalZero && intendedSum != sum)
			return -1;

		// keep looping through anti-diagonal elements & check if row & col coincide
		// with zeroi & zeroj, then ignore this sum
		sum = 0;
		diagonalZero = false;
		for (int j = mat[0].length - 1; j >= 0; j--) {
			if (mat[0].length - 1 - j == zeroi && j == zeroj) {
				diagonalZero = true;
				break;
			}
			sum += mat[mat[0].length - 1 - j][j];
		}
		if (!diagonalZero && intendedSum != sum)
			return -1;

		// now loop through zeroith row to calculate intended sum
		sum = 0;
		for (int j = 0; j < mat[0].length; j++)
			sum += mat[zeroi][j];

		int num = intendedSum - sum;

		// now check zerojth col to verify if it sums up to intended sum
		sum = 0;
		for (int i = 0; i < mat.length; i++)
			sum += mat[i][zeroj];

		if (sum + num != intendedSum)
			return -1;

		return num;

	}

	public static void main(String[] args) throws Exception {
		// int[][] mat = { { 4, 0, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
		int[][] mat = { { 5, 5 }, { 5, 0 } };

		System.out.println(missingNum(mat));

	}
}
