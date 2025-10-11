package DSA.Bucket2._08_search._02_BinarySearch._04_BinarySearch_Matrix;

//https://youtu.be/JXU4Akft7yk?list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&t=381

/* If matrix is sorted as whole */

// Algo :
// hypothetically flatten 2D array to 1D and BS for target. Length of 1D arr will now be n*m. Hence TC reduces to : O(log(n*m))
// now translating 2D matrix indices as l = 0, r = (n*m - 1)
// Now BS on above range will be finding mid and converting this mid to respective coordinates

// matrix coordinates (row, col) : row -> mid/noOfCol, col -> mid%noOfCol

public class _02_03_SearchInMatrix_Imp {

	private static boolean findElement(int[][] mat, int target) {

		// define range if this 2D gets converted to 1D
		int l = 0, r = mat.length * mat[0].length - 1, mid = 0;
		int row = 0, col = 0;

		while (l <= r) {

			// find mid and then convert to 2D coordinates and do BS
			mid = (l + r) / 2;
			row = mid / mat[0].length;
			col = mid % mat[0].length;

			if (mat[row][col] < target)
				l = mid + 1;
			else if (mat[row][col] > target)
				r = mid - 1;
			else
				return true;
		}

		return false;

	}

	public static void main(String[] args) {
		int[][] mat = { { 3, 4, 7, 9 }, { 12, 13, 16, 18 }, { 20, 21, 23, 29 } };
		int target = 23;
		System.out.println(findElement(mat, target));
	}

}
//TC : O(log(n * m)) (no of elements in 2D matrix n*m and BS on them) 
//SC : O(1)