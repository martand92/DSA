package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/determinant-of-a-matrix-1587115620/1
public class _27_DeterminantOfMatrix_Incomp {

	static int findDeterminant(int[][] matrix) {
		return 1;

	}

	public static void main(String[] args) throws Exception {
		// int[][] matrix = { { 4, 0, 2, 1 }, { 3, 5, 7, 1 }, { 8, 1, 6, 1 }, { 3, 1, 5,
		// 2 } };
		int[][] matrix = { { 5, 4, 0, 2, 1 }, { 5, 3, 5, 7, 1 }, { 5, 8, 1, 6, 1 }, { 5, 3, 1, 5, 2 },
				{ 1, 1, 1, 1, 1 } };
		// int[][] matrix = { { 5, 7, 1 }, { 1, 6, 1 }, { 1, 5, 2 } };
		// int[][] matrix = { { 6, 1 }, { 5, 2 } };
		// int det = findDeterminant(matrix);

		System.out.println(findDeterminant(matrix));

	}
}
