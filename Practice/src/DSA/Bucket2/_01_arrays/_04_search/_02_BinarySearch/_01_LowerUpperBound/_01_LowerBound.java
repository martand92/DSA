package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._01_LowerUpperBound;

public class _01_LowerBound {

	public static int lowerBound(int[] arr, int target, int l, int r) {

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

		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
		int target = 12;
		System.out.println(lowerBound(arr, target, 0, arr.length - 1));
	}

}
