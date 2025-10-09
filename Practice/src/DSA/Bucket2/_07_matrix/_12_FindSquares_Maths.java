package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/squares-in-a-matrix5716/1
public class _12_FindSquares_Maths {
	static int r = 0;

	public static void main(String[] args) {

		int m = 2, n = 1;

		System.out.println(squaresInMatrix(m, n, 0));

	}

	public static int squaresInMatrix(int m, int n, int count) {
		int total = 0;
		int min = Math.min(m, n);

		for (int k = 1; k <= min; k++) {
			total += (m - k + 1) * (n - k + 1);
		}
		return total;

	}
}
