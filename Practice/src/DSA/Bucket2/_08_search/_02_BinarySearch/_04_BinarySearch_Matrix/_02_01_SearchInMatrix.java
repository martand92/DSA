package DSA.Bucket2._08_search._02_BinarySearch._04_BinarySearch_Matrix;

/* If matrix is only sorted by row, but need not be sorted by col & need not be sorted as whole */

// Algo : As array is sorted, first find probable row in the matrix where target could be present by checking 1st and last term of each row
// Once you find probable row, then check for target in that row using binary search
public class _02_01_SearchInMatrix {

	private static boolean findElement(int[][] mat, int target) {

		int probableRow = -1;
		// loop through all rows and check probable row of target
		for (int i = 0; i < mat.length; i++) {

			if (mat[i][0] <= target && mat[i][mat[0].length - 1] >= target) {
				probableRow = i;
				break;
			}
		}

		// if ele was not in matrix
		if (probableRow == -1)
			return false;

		// now BS probableRow to find ele, if present then return true else false
		int l = 0, r = mat[0].length - 1, mid = 0;

		while (l <= r) {

			mid = (l + r) / 2;

			if (mat[probableRow][mid] < target)
				l = mid + 1;
			else if (mat[probableRow][mid] > target)
				r = mid - 1;
			else if (mat[probableRow][mid] == target)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] mat = { { 3, 4, 7, 9 }, { 20, 21, 23, 29 }, { 12, 13, 16, 18 } };
		int target = 22;
		System.out.println(findElement(mat, target));
	}

}
//TC : O(n + logm) : to loop through all available rows to find probable row + to BS probable row 
//SC : O(1)