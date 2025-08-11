package DSA.Bucket2._06_search._02_BinarySearch._02_RotatedArr;

public class _11_03_CountNoOfRotations {

	public static int noOfRotations(int[] arr) {

		int l = 0, r = arr.length - 1;
		int mid = 0;

		// if not rotated, then no of rotations = 0
		if (arr[l] < arr[r])
			return 0;

		// finding min num in rotated array
		while (l <= r) {

			mid = (l + r) / 2;

			if (arr[mid] < arr[mid - 1])
				return mid;

			else if (arr[mid] > arr[r])
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(noOfRotations(arr));
	}

}
