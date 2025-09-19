package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/missing-number-in-matrix5316/1
public class _26_MissingNumInMatrix {

	// Step 1: first check all rows other than row consisting 0 adds up to same
	// number
	// Step 2: then check all columns other than column consisting 0 adds up to same
	// number as initially found sum
	// Step 3 : Then check both diagonals (except containing 0) adds upto same sum
	// Step 4: if all row , columns, diagonals adds upto to same sum then its
	// possible to replace value of 0 else not possible so return -1

	public static int missingNum(int[][] mat) {

		int zeroi = 0, zeroj = 0, intendedSum = Integer.MIN_VALUE, sum = 0;

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

			if (intendedSum != Integer.MIN_VALUE && intendedSum != sum)
				return -1;

			intendedSum = sum;

		}

		// sum up all cols except for the col with 0 & check if all cols has same sum
		for (int j = 0; j < mat[0].length; j++) {
			sum = 0;
			if (j != zeroj) {// if current col is same as col containing 0 then skip that col
				for (int i = 0; i < mat.length; i++)
					sum += mat[i][j];
			}

			if (intendedSum != Integer.MIN_VALUE && intendedSum != sum)
				return -1;

			intendedSum = sum;
		}

		// check if diagonal has 0, if yes then no need to check for diagonal sum
		if (zeroi != zeroj) {

			sum = 0;
			for (int i = 0; i < mat.length; i++) {
				if (i != zeroi) {
					sum += mat[i][i];
					if (intendedSum != Integer.MIN_VALUE && intendedSum != sum)
						return -1;
				}
			}

			sum = 0;
			for (int j = mat.length - 1; j >= 0; j--) {
				if (j != zeroj) {
					sum += mat[j][j];
					if (intendedSum != Integer.MIN_VALUE && intendedSum != sum)
						return -1;
				}
			}
		}

		sum = 0;
		for (int j = 0; j < mat[0].length; j++)
			sum += mat[zeroi][j];

		return intendedSum - sum;

	}

	public static void main(String[] args) throws Exception {
		int[][] mat = { { 4, 0, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
		// int[][] mat = { { 5, 5 }, { 5, 0 } };

		System.out.println(missingNum(mat));

	}
}
