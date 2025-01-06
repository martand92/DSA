package DSA._01_arrays._05_matrix;

public class _01_SearchInMatrix {

	public static void main(String[] args) {
		int[][] a = { { 3, 30, 38 }, { 44, 52, 54 }, { 57, 60, 69 }, { 1, 2, 3 } };
		int key = 4;
		boolean found = false;

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[0].length; j++) {

				if (a[i][j] == key) {
					found = true;
					return;
				}

			}
		}

		System.out.println(found);

	}
}
