package DSA.Bucket2._08_search._02_BinarySearch._01_LowerUpperBound;

//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
public class _04_FirstLastOccrOfX_Imp {

	public static int binarySearchLeft(int[] arr, int l, int r, int x) {

		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;
			else if (x > arr[mid])
				l = mid + 1;
			else {// if x is found
				ans = mid;
				r = mid - 1;// look at the left
			}
		}

		return ans;
	}

	public static int binarySearchRight(int[] arr, int l, int r, int x) {

		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (x < arr[mid])
				r = mid - 1;
			else if (x > arr[mid])
				l = mid + 1;
			else {
				ans = mid;
				l = mid + 1;// look at the right
			}
		}

		return ans;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 5, 5, 5, 5, 67, 123, 125 };
		int x = 1;
		// int x = 5;

		System.out.println("left " + binarySearchLeft(arr, 0, arr.length - 1, x));
		System.out.println("right " + binarySearchRight(arr, 0, arr.length - 1, x));
	}
}