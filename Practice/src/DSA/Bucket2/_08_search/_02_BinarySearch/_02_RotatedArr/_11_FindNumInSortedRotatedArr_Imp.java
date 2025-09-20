package DSA.Bucket2._08_search._02_BinarySearch._02_RotatedArr;

// https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array0959/1

// Algo : 
// first find smallest element in an array
// Then check if key is in left or right side of this smallest element
// Then binary search key either left or right side of pivot

public class _11_FindNumInSortedRotatedArr_Imp {

	// Find index of smallest element (rotation point)
	public static int getPivot(int[] arr, int l, int r) {

		while (l < r) {

			int mid = (l + r) / 2;

			if (arr[mid] > arr[r])
				l = mid + 1;
			else
				r = mid;
		}

		return l;
	}

	public static int binarySearch(int[] arr, int key, int l, int r) {

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;
	}

	public static int findNum(int[] arr, int key) {

		int l = 0, r = arr.length - 1;

		// Checking if array is rotated
		if (arr[l] > arr[r]) {

			int pivot = getPivot(arr, l, r); // pivot-1 will be the largest element

			if (key >= arr[0] && key <= arr[pivot - 1]) // find in left half
				return binarySearch(arr, key, 0, pivot - 1);
			else
				return binarySearch(arr, key, pivot, arr.length - 1); // find in right half

		} else // if not rotated then search whole array as is
			return binarySearch(arr, key, 0, r);
	}

	public static void main(String[] args) {

		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int key = 6;

//		int arr[] = { 6, 1, 2, 3, 4, 5 };
//		int key = 7;

		System.out.println(findNum(arr, key));
	}
}