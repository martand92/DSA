package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._05_Imp_BS;

//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
public class _08_03_FirstLastOccurencesOfX_logN {

	public static int binarySearchFirst(int[] arr, int l, int r, int x) {
		int first = -1;
		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;

			else if (x > arr[mid])
				l = mid + 1;

			else {// if x is found
				first = mid;
				r = mid - 1;
			}
		}

		return first;
	}

	public static int binarySearchLast(int[] arr, int l, int r, int x) {
		int last = -1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;

			else if (x > arr[mid])
				l = mid + 1;

			else {// if x is found
				last = mid;
				l = mid + 1;
			}
		}

		return last;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 5, 5, 5, 5, 67, 123, 125 };
		int x = 1;

		int left = binarySearchFirst(arr, 0, arr.length - 1, x);
		int right = binarySearchLast(arr, 0, arr.length - 1, x);

		System.out.println("Left:" + left + ", Right:" + right);
	}

}
