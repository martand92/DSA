package DSA.Bucket2._01_arrays._04_search._02_BinarySearch._02_RotatedArr;

//https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array0959/1

// Algo : 
// Binary Search pivot : pivot is the max element in rotate array : if arr[pivot] > arr[pivot+1]
// Then check if key is in left side or right side of array
// Then binary search key from pivot to the end of array
public class _11_01_FindGivenNumInSortedRotatedArr_logN_Imp {

	public static void main(String[] args) {
//
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int key = 6;
//		

//		int arr[] = { 6, 1, 2, 3, 4, 5 };
//		int key = 7;

		int l = 0, r = arr.length - 1, pivot = 0;

		// First check if arr is rotated
		if (arr[r] < arr[l]) {

			int mid = l + (r - l) / 2;

			while (l <= r) {

				mid = l + (r - l) / 2;

				if (arr[mid - 1] > arr[mid]) // Find Min Num in sorted rotated array
					break;

				else if (arr[mid] > arr[r]) // or compare with arr[l]
					l = mid + 1;

				else
					r = mid - 1;
			}

			// Save mid - 1 which is highest num in sorted rotated array as pivot
			// As key to be found will be either left or right of this pivot
			pivot = mid - 1;

		} else
			pivot = arr.length - 1;

		// If arr[pivot] = key then stop
		if (arr[pivot] == key) {
			System.out.println(pivot);
			return;
		}

		// After finding pivot, finalize on to binary search left or right side of array

		// If arr is not rotated
		if (pivot == arr.length - 1)
			binarySearch(0, arr.length - 1, arr, key);

		else {

			if (key < arr[pivot] && key >= arr[0]) // search of left
				System.out.println(binarySearch(0, pivot - 1, arr, key));

			else if (key < arr[pivot] && key <= arr[arr.length - 1]) // search of right
				System.out.println(binarySearch(pivot + 1, arr.length - 1, arr, key));

			// Key not found in arr
			else
				System.out.println(-1);

		}

	}

	public static int binarySearch(int l, int r, int[] arr, int key) {

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

}
