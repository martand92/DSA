package DSA.Bucket2._01_arrays._06_search._03_RotatedArr;

//https://practice.geeksforgeeks.org/problems/minimum-number-in-a-sorted-rotated-array-1587115620/1
//https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
public class _11_02_FindMinInSortedRotatedArr_logN_Imp {

	public static void main(String[] args) {

		// int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		int[] arr = { 3, 4, 5, 1, 2 };

		int l = 1, r = arr.length - 1;

		// if not rotated then first element will be the min
		if (arr[0] < arr[r])
			System.out.println(arr[0]);

		// if rotated
		else {

			while (l <= r) {

				int mid = l + (r - l) / 2;

				if (arr[mid - 1] > arr[mid]) { // if mid-1 > mid, then mid has lowest num
					System.out.println(arr[mid]);
					break;

					// Check if right most element is less than arr[mid], then keep moving right
					// else move left
				} else if (arr[mid] > arr[r])
					l = mid + 1;

				else
					r = mid - 1;
			}
		}
	}
}