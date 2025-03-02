package DSA.Bucket2._01_arrays._06_search._04_BinarySearchAns.min_max;

public class _19_FindSqrtOfNum {

	public static int findSqrt(int n) {

		// the range is initially fixed as 1 -> n as n sqrt of n will always be less
		// than n
		int l = 1, r = n, mid = 0;

		while (l <= r) {

			// here mid will indicate if its square produces given num, if produces higher
			// then discard right else discard left
			mid = (l + r) / 2;

			if ((mid * mid) > n)
				r = mid - 1;

			else if (mid * mid < n)
				l = mid + 1;

			else
				return mid;
		}

		// here r will cross over last possible ans
		return r;
	}

	public static void main(String[] args) {
		int n = 35;
		System.out.println(findSqrt(n));
	}

}
//TC : O(log n)
//SC : O(1)