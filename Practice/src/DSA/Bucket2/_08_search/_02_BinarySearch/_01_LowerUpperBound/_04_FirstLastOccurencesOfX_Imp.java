package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
public class _04_FirstLastOccurencesOfX_Imp {

	public static int binarySearchLeft(int[] arr, int l, int r, int x) {

		int first = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;
			else if (x > arr[mid])
				l = mid + 1;
			else {// if x is found
				first = mid;
				r = mid - 1;// look at the left
			}
		}

		return first;
	}

	public static int binarySearchRight(int[] arr, int l, int r, int x) {

		int last = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;
			else if (x > arr[mid])
				l = mid + 1;
			else {
				last = mid;
				l = mid + 1;// look at the right
			}
		}

		return last;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 5, 5, 5, 5, 67, 123, 125 };
		int x = 1;

		int left = binarySearchLeft(arr, 0, arr.length - 1, x);
		int right = binarySearchRight(arr, 0, arr.length - 1, x);

		System.out.println("Left:" + left + ", Right:" + right);
	}

}
