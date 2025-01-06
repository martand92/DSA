package DSA._01_arrays._06_search._05_BinarySearch_On2DArrays;

// Algo : As array is sorted, first find probable row in the matrix where target could be present by checking 1st and last term of each row
// Once you find probable row, then check for target in that row using binary search
public class _02_01_SearchIn2DArr {

	private static boolean findElement(int[][] mat, int target) {

		int probableRow = 0;
		// loop through all rows and check range and decide if given target is in this
		// range
		for (int i = 0; i < mat.length; i++) {

			if (mat[i][0] <= target && mat[i][mat[0].length - 1] >= target) {
				probableRow = i;
				break;
			}
		}

		// now binary search this probableRow to find element, if present return true
		// else false
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
		int[][] mat = { { 3, 4, 7, 9 }, { 12, 13, 16, 18 }, { 20, 21, 23, 29 } };
		int target = 22;
		System.out.println(findElement(mat, target));
	}

}
//TC : O(n) (to loop through all available rows to find probable row) + O(log m) (to BS probable row) 
//SC : O(1)