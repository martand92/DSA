package DSA.Bucket5._08_recursion.easy;

public class _01_01_FindNumberOfPaths {

	public static int findingPath(int n, int m, int i, int j) {

		if (i == n || j == m)
			return 0;

		if (i == n - 1 && j == m - 1)
			return 1;

		int l = findingPath(n, m, i, j + 1);
		int r = findingPath(n, m, i + 1, j);

		return l + r;
	}

	public static void main(String[] args) {
		// n * m
		int n = 3;
		int m = 3;
		System.out.println(findingPath(n, m, 0, 0));
	}
}
