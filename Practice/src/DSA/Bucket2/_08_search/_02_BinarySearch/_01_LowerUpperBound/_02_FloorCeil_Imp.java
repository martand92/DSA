package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

/* floor : greatest number less than or equal to target
 * ceil : lowest number greater than or equal to target */

//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
public class _02_FloorCeil_Imp {

	public static int floor(int[] arr, int target, int l, int r) {

		int mid = 0;
		int ans = -1;// if target is lesser than all the arr elements then there is no floor

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target)
				return mid;

			else if (arr[mid] < target) {
				ans = mid;
				l = mid + 1;// move right towards target's floor
			} else
				r = mid - 1;
		}

		return ans;
	}

	public static int ceil(int[] arr, int target, int l, int r) {
		int mid = 0;
		int ans = arr.length;// if target is greater than all arr elements then ceil is outside array

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (arr[mid] == target)
				return mid;

			else if (arr[mid] > target) {
				ans = mid;
				r = mid - 1;// move left towards target's ceil
			} else
				l = mid + 1;
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 12 };
		int target = 0;
		System.out.println(floor(arr, target, 0, arr.length - 1));
		System.out.println(ceil(arr, target, 0, arr.length - 1));
	}
}