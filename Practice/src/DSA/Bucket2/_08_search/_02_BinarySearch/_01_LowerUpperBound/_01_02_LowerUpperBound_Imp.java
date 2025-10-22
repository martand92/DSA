package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

public class _01_02_LowerUpperBound_Imp {

	public static int lowerBound(int[] arr, int target, int l, int r) {

		// l : at invalid lower end
		// r : at valid higher end
		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] >= target) {
				r = mid - 1;
			} else
				l = mid + 1;
		}

		return l;// l will eventually move to lower valid end
	}

	public static int upperBound(int[] arr, int target, int l, int r) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] > target) {
				r = mid - 1; // look for smaller index on left
			} else
				l = mid + 1;
		}

		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
		int target = 12;
		System.out.println("Lower Bound : " + lowerBound(arr, target, 0, arr.length - 1));
		System.out.println("Upper Bound : " + upperBound(arr, target, 0, arr.length - 1));
	}
}