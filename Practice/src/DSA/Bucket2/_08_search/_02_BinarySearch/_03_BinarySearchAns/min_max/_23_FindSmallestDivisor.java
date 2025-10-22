package DSA.Bucket2._08_search._02_BinarySearch._03_BinarySearchAns.min_max;

//https://www.youtube.com/watch?v=UvBKTVaG6U8
//https://www.naukri.com/code360/problems/smallest-divisor-with-the-given-limit_1755882
public class _23_FindSmallestDivisor {

	public static int maxElement(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			max = Math.max(max, arr[i]);

		return max;
	}

	// finding sum of divisors derived using mid is in limit
	public static boolean isPossible(int[] arr, int mid, int limit) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % mid == 0)
				sum += arr[i] / mid;
			else
				sum += arr[i] / mid + 1;
		}

		return sum <= limit;
	}

	public static int findSmallestDivisor(int[] arr, int limit) {
		// divisor will range from 1 -> max(arr[])
		// r will be pointing to max(arr[]) as anything higher will lead to same divisor
		// result = 1, i.e, arr[i] / max(arr[i]) = 1
		int l = 1, r = maxElement(arr), mid = 0;

		while (l <= r) {

			// here mid indicates divisor whose sum after division is lesser than limit then
			// discard right else left
			mid = (l + r) / 2;

			if (isPossible(arr, mid, limit))
				r = mid - 1; // try smaller divisor

			else
				l = mid + 1; // need larger divisor
		}

		return l; // l will be the smallest valid divisor
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 9 };
		int limit = 6;

		System.out.println(findSmallestDivisor(arr, limit));
	}
}
