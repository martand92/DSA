package DSA.Bucket5._10_dynamicprogramming._06_CountPaths;

public class _01_02_Recursion {

	public static int countPaths(int[][] matrix, int m, int n) {

		if (m == matrix.length || n == matrix[0].length)
			return 0;

		if (m == matrix.length - 1 && n == matrix[0].length - 1)
			return 1;

		int left = countPaths(matrix, m + 1, n);
		int right = countPaths(matrix, m, n + 1);
		return left + right;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		System.out.println(countPaths(matrix, 0, 0));
	}

}

//TC : As at every cell there is need to explore 2 routes, either up or left hence 2 choices.
// so TC : 2^(m+n)
// SC : O(path length) = O(m-1)(n-1)