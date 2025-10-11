package DSA.Bucket2._08_search._02_BinarySearch._04_BinarySearch_Matrix;

//https://www.youtube.com/watch?v=9ZbB397jU4k

/* If matrix is sorted by both row and col, but need not be sorted as whole */

/* Algo :  Stair case approach. 
 * 
 * stand at a position where for you can either get rid off searching that column or row for target
 * if target for sure will not be present in that column then move to next col else if target is not present in that row then move to next row
 * 
 * So starting position : row=0, col=mat[0].length-1, where for sure you can remove row or col from search space 
 * because at this coordinate all elements below it are larger and all elements left to it are smaller 
 * 
 * Hence if target < curr element, then move left because all elements below are larger if target > curr element, 
 * then move down because all elements to the left are smaller
 */

public class _02_02_SearchInMatrix {

	public static boolean findElement(int[][] mat, int target) {

		// starting position
		int row = 0, col = mat[0].length - 1;

		while (row < mat.length && col >= 0) {

			if (target < mat[row][col])
				col--;
			else if (target > mat[row][col])
				row++;
			else
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[][] mat = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 14;

		System.out.println(findElement(mat, target));
	}
}

//O(n+m)
