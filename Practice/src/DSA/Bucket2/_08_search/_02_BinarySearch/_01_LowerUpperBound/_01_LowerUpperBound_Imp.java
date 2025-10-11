package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

/* Lower bound : first index with arr[i] >= target. It is the first occurrence of target element. If element not found index of first element greater than target is returned
 * Upper bound : first index with arr[i] > target. It is the first occurrence of element greater than target element
 * 
 * Then:
 * All elements in arr[0 ... lb-1] are < target
 * All elements in arr[lb ... ub-1] are == target
 * All elements in arr[ub ... end] are > target
 */

public class _01_LowerUpperBound_Imp {

	public static int lowerBound(int[] arr, int target, int l, int r) {

		int mid = 0;
		int ans = arr.length; // if all elements < target then insert at the end

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] >= target) {
				ans = mid; // possible ans
				r = mid - 1;// continue to check on left as you need index of first occurrence
			} else // arr[mid] < target
				l = mid + 1;
		}

		return ans;
	}

	public static int upperBound(int[] arr, int target, int l, int r) {

		int mid = 0;
		int ans = arr.length; // if “no element greater than target” then insert at the end

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] > target) {
				ans = mid; // possible ans
				r = mid - 1; // look for smaller index on left
			} else
				l = mid + 1;
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
		int target = 12;
		System.out.println("Lower Bound : " + lowerBound(arr, target, 0, arr.length - 1));
		System.out.println("Upper Bound : " + upperBound(arr, target, 0, arr.length - 1));
	}
}