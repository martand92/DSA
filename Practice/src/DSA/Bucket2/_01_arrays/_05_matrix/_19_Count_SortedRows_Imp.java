package DSA.Bucket2._01_arrays._05_matrix;

//https://practice.geeksforgeeks.org/problems/count-sorted-rows2702/1
public class _19_Count_SortedRows_Imp {
	static int r = 0;

	public static void main(String[] args) {

		int Mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int count = 0;

		for (int i = 0; i < Mat.length; i++) {

			int sorted = 0;

			for (int j = 0; j < Mat[0].length - 1; j++) {
				if (Mat[i][j] > Mat[i][j + 1])
					sorted++;
				if (Mat[i][j] < Mat[i][j + 1])
					sorted--;
			}

			if (sorted == Mat.length - 1 || sorted == 1 - Mat.length)
				count++;
		}
		
		System.out.println(count);

	}
}
