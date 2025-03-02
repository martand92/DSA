package DSA.Bucket4._08_recursion;

public class _02_FindNumberOfPaths {

	public static int findingPath(int n, int m, int i, int j, int count) {

		if (n == i || m == j)
			return count;

		count = findingPath(n, m, i, j + 1, count);
		count = findingPath(n, m, i + 1, j, count);

		if (i == n - 1 && j == m - 1)
			count++;

		return count;
	}

	public static void main(String[] args) {
		// n * m
		int n = 3;
		int m = 3;
		int count = findingPath(n, m, 0, 0, 0);
		System.out.println(count);
	}
}
