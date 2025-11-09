package DSA.Bucket3._04_recursion.easy;

public class _01_01_FindNumberOfPaths {

	public static int findingPath(int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		if (n == 1 && m == 1)
			return 1;

		return findingPath(n, m - 1) + findingPath(n - 1, m);
	}

	public static void main(String[] args) {
		// n * m
		int n = 2;
		int m = 3;
		System.out.println(findingPath(n, m));
	}
}
