package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns.min_max;

public class _20_FindNthRootOfNum {

	public static int findNthRootOfM(int mid, int n) {

		int ans = 1;
		for (int i = 0; i < n; i++)
			ans *= mid;

		return ans;
	}

	public static int findNthRoot(int m, int n) {

		// the range is initially fixed as 1 -> m as nth root of m will alwasy be less
		// than m
		int l = 1, r = m, mid = 0;

		while (l <= r) {

			mid = (l + r) / 2;
			int ans = findNthRootOfM(mid, n);

			if (ans > m)
				r = mid - 1;

			else if (ans < m)
				l = mid + 1;

			else
				return mid;
		}

		// here r will cross over last possible ans meaning ans is not found
		return -1;
	}

	public static void main(String[] args) {
		int n = 2;
		int m = 16;
		System.out.println(findNthRoot(m, n));
	}
}
//TC : O(log m * n) - log m for binary searching mth root * n for multiplying n times
//SC : O(1)