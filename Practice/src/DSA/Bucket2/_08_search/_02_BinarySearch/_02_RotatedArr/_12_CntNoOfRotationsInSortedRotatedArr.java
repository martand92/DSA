package DSA.Bucket2._08_search._02_BinarySearch._02_RotatedArr;

public class _12_CntNoOfRotationsInSortedRotatedArr {

	public static int findRotationPoint(int[] arr, int l, int r) {

		int mid = 0;

		if (arr[0] < arr[r])
			return 0;

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

	public static int noOfRotations(int[] arr) {

		int minIndex = findRotationPoint(arr, 0, arr.length - 1);
		if (minIndex == 0)
			return 0;
		else
			return arr.length - minIndex;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(noOfRotations(arr));
	}
}