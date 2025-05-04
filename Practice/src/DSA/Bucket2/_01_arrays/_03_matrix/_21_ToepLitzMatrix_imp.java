package DSA.Bucket2._01_arrays._03_matrix;

//https://practice.geeksforgeeks.org/problems/toeplitz-matrix/1
public class _21_ToepLitzMatrix_imp {

	public static void main(String[] args) {

		int mat[][] = { { 6, 7, 8 }, { 4, 6, 7 }, { 1, 4, 6 } };

		for (int i = 0; i < mat.length - 1; i++) {

			for (int j = 0; j < mat[0].length - 1; j++) {

				if (mat[i][j] != mat[i + 1][j + 1]) {
					System.out.println(false);
					return;
				}
			}
		}

		System.out.println(true);

	}
}
