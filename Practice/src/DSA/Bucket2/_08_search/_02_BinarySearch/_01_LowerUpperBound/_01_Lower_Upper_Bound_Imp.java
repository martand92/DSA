package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

/* Lower bound is smallest index in sorted array where the element is greater than or equal to the target
 * If all the elements in the given array are smaller than the target, the lower bound will be the length of the array */

public class _01_Lower_Upper_Bound_Imp {

	public static String lowerBound(int[] arr, int target, int l, int r) {

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target)
				return "Lower bound : " + mid + " Upper Bound : " + mid;

			else if (arr[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return "Lower bound : " + l + " Upper Bound : " + r;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
		int target = 12;
		System.out.println(lowerBound(arr, target, 0, arr.length - 1));
	}
}