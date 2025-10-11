package DSA.Bucket2._08_search._02_BinarySearch._04_BinarySearch_Matrix;

//https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1

//As each row is sorted find 1st occurrence of 1. Then no of 1's in that row will be arr.length-index of 1st 1
public class _01_01_MaxOnes {

	public static void main(String[] args) {

		// int[][] matrix = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };
		// int[][] matrix = { { 0, 1 }, { 1, 1 } };
		int[][] matrix = { { 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1 } };

		int i = 0, count = 0, rowNo = 0, index = 0;

		for (i = 0; i < matrix.length; i++) {

			int l = 0, r = matrix[0].length - 1;
			int mid = (l + r) / 2;

			// here l and r converges onto first occurrence of 1 in given row
			while (l <= r) {

				if (matrix[i][mid] == 1) {// found 1 then search more towards left
					index = mid;// store current 1's index, this might or might not be left most
					r = mid - 1;
				} else
					l = mid + 1;

				mid = (l + r) / 2;
			}

			if ((matrix[0].length - index) > count) {
				count = matrix[0].length - index;
				rowNo = i;
			}

		}
		System.out.println(rowNo);
	}
}

//TC : O(nlogm)