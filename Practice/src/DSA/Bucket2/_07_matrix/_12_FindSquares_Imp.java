package DSA.Bucket2._07_matrix;

//https://practice.geeksforgeeks.org/problems/squares-in-a-matrix5716/1
public class _12_FindSquares_Imp {
	static int r = 0;

	public static void main(String[] args) {

		int m = 2, n = 1;

		System.out.println(squaresInMatrix(m, n, 0));

	}

	public static int squaresInMatrix(int m, int n, int count) {
		if (m == 0 || n == 0)
			return count;

		count++;
		
		count = squaresInMatrix(m - 1, n, count);
		count = squaresInMatrix(m, n - 1, count);
		return count;

	}
}
