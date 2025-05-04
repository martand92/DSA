package DSA.Bucket2._01_arrays._04_search;

//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
public class _08_02_FirstLastOccrOfX_logN_Imp {

	public static int binarySearch(int[] arr, int l, int r, int x) {

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;

			else if (x > arr[mid])
				l = mid + 1;

			else
				return mid;
		}

		return -1;
	}

	public static int binarySearchLeft(int[] arr, int l, int r, int x, int initMid) {

		int mid = binarySearch(arr, l, r, x);

		if (mid == -1)
			return initMid;

		return binarySearchLeft(arr, l, mid - 1, x, mid);
	}

	public static int binarySearchRight(int[] arr, int l, int r, int x, int initMid) {

		int mid = binarySearch(arr, l, r, x);

		if (mid == -1)
			return initMid;

		return binarySearchRight(arr, mid + 1, r, x, mid);
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int x = 5;
		int l = 0, r = arr.length - 1;

		int mid = binarySearch(arr, l, r, x);
		if (mid == -1)
			return;

		int left = binarySearchLeft(arr, l, mid - 1, x, mid);
		int right = binarySearchRight(arr, mid + 1, r, x, mid);

		System.out.println("Left:" + left + ", Right:" + right);
	}

}
