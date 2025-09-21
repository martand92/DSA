package DSA.Bucket2._08_search._02_BinarySearch._02_RotatedArr;

// Rotation point is the index of smallest element in rotated array
public class _10_FindRotationPoint {

	public static int findRotationPoint_1(int[] arr, int l, int r) {

		if (arr[0] < arr[r]) // if not rotated
			return 0;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid - 1] > arr[mid])// mid has smallest ele
				return mid;
			else if (arr[mid] > arr[r]) // smallest ele is right of mid
				l = mid + 1;
			else // smallest ele is left of mid
				r = mid - 1;
		}

		return -1;

	}

	public static int findRotationPoint_2(int[] arr, int l, int r) {

		while (l < r) {

			int mid = (l + r) / 2;

			if (arr[mid] > arr[r]) // smallest ele is right of mid
				l = mid + 1;
			else if (arr[mid] <= arr[r]) // smallest ele is left of mid
				r = mid;// note : r = mid and not mid - 1
		}

		return l;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(findRotationPoint_1(arr, 0, arr.length - 1));
		System.out.println(findRotationPoint_2(arr, 0, arr.length - 1));
	}

}
