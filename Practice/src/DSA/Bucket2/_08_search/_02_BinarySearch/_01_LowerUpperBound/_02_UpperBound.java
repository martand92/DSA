package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

public class _02_UpperBound {

	public static int upperBound(int[] arr, int target, int l, int r) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target)
				return mid;

			else if (arr[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return r;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 12 };
		int target = 11;
		System.out.println(upperBound(arr, target, 0, arr.length - 1));
	}

}
