package DSA.Bucket2._01_arrays._05_matrix;

//https://practice.geeksforgeeks.org/problems/predict-the-column/1
public class _07_PredictColumn {

	public static void main(String[] args) {

		int[][] a = { { 1, 1, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		int maxZeros = 0, count = 0, col = 0;

		for (int j = 0; j < a[0].length; j++) {
			for (int i = 0; i < a.length; i++) {

				if (a[i][j] == 0)
					count++;

			}
			if (maxZeros < count) {
				maxZeros = count;
				col = j;
			}
			
			count = 0;
		}

		System.out.println(col);

	}
}
