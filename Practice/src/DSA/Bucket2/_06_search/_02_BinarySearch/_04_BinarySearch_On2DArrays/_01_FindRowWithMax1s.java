package DSA.Bucket2._06_search._02_BinarySearch._04_BinarySearch_On2DArrays;

//https://www.youtube.com/watch?v=SCz-1TtYxDI
//https://www.naukri.com/code360/problems/row-with-maximum-1-s_1112656

//Algo :
//brute force : loop through all rows and columns and count 1s for each row and save row with max 1s. TC : O(row*col)
//As each row is sorted find 1st occurrence of 1. Then no of 1's in that row will be arr.length - index of 1st 1
public class _01_FindRowWithMax1s {

	private static int findRowWithMax1s(int[][] mat) {

		int maxCountOf1s = 0, maxCountRow = 0;

		for (int i = 0; i < mat.length; i++) {// O(row)

			// for this row find 1st 1
			int l = 0, r = mat[0].length - 1, mid = 0;

			while (l <= r) { // O(log col)

				mid = (l + r) / 2;

				if (mat[i][mid] == 0)
					l = mid + 1;

				else if (mat[i][mid] == 1)
					r = mid - 1;
			}

			// l will be pointing to 1st 1 occurrence, So no of 1s will be (n - l)
			if ((mat[0].length - l) > maxCountOf1s) { // if multiple rows exist with same max 1s count, then return
														// smaller row
				maxCountOf1s = mat[0].length - l;
				maxCountRow = i;
			}
		}

		return maxCountRow;
	}

	public static void main(String[] args) {
		// int[][] mat = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
		int[][] mat = { { 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1 } };
		System.out.println(findRowWithMax1s(mat));
	}
}
//TC : O(row * log col)
//SC : O(1)
