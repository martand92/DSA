package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._04_BinarySearch_On2DArrays;

//https://www.youtube.com/watch?v=nGGp5XBzC4g
//https://www.naukri.com/code360/problems/find-peak-element_7449073

//need to send coordinate of the element in matrix whose left, right, top and bottom are all less than current

//Algo:
//Have col=0 as left and col=arr.lenght-1 as right for matrix and then do binary search on the columns. 
//This will confirm that both top and bottom of this element are less, now need to check if left/right are less

//After finding max element in that col, check for all its neighbors if they are less. If they are then this element is peak
//but if left is larger than current then discard right and binary search on left (0 -> curr col - 1)
//if right is larger than current then discard left and binary search on right (curr col + 1 -> n)

public class _04_FindPeak {

	public static String findPeak(int[][] mat) {

		int l = 0, r = mat[0].length - 1, midCol = 0;
		int maxRow = 0, maxCol = 0; // to store row & col coordinates of max element in current col

		while (l <= r) {

			midCol = (l + r) / 2;

			// now in this midCol check for max element and its coordinates. This will
			// confirm that both top and bottom are smaller
			int max = Integer.MIN_VALUE;

			for (int row = 0; row < mat.length; row++) {
				if (mat[row][midCol] > max) {
					max = mat[row][midCol];
					maxRow = row;
					maxCol = midCol;
				}
			}

			// next check if left col val is greater than current only if current col != 0
			if (maxCol != 0 && mat[maxRow][maxCol - 1] > mat[maxRow][maxCol])
				r = midCol - 1; // if left val is greater then reduce BS window to only left

			// next check if right col val is greater than current only if current col != n
			else if (maxCol != mat[0].length - 1 && mat[maxRow][maxCol + 1] > mat[maxRow][maxCol])
				l = midCol + 1; // if right val is greater then reduce BS window to only right

			else
				return "row:" + maxRow + " col:" + maxCol;
		}

		return "";

	}

	public static void main(String[] args) {
		int[][] mat = { { 4, 2, 5, 1, 4, 5 }, { 2, 9, 3, 2, 3, 2 }, { 1, 7, 6, 0, 1, 3 }, { 3, 6, 2, 3, 7, 2 } };
		System.out.println(findPeak(mat));
	}

}
