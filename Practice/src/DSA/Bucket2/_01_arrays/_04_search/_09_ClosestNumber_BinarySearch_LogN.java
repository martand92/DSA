package DSA.Bucket2._01_arrays._04_search;

//https://practice.geeksforgeeks.org/problems/find-the-closest-number5513/1
public class _09_ClosestNumber_BinarySearch_LogN {

	public static void main(String[] args) {

		int[] arr = { 6, 7, 7, 9, 11, 12, 16, 16, 18 };
		int k = 13;

//		int[] arr = { 3, 12, 14, 15, 17 };
//		int k = 19;

//		int[] arr = { 12, 16 };
//		int k = 15;

		int l = 0, r = arr.length - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] == k)
				break;

			else if (k < arr[mid])
				r = mid - 1;

			else
				l = mid + 1;

		}

		if (r < l) {
			//edge case
			if (r < 0)
				System.out.println(arr[0]);
			
			//edge case
			else if (l > arr.length - 1)
				System.out.println(arr[arr.length - 1]);
			
			//finding closest num
			else {
				if (Math.abs(k - arr[r]) >= Math.abs(arr[l] - k))
					System.out.println(arr[l]);
				else
					System.out.println(arr[r]);
			}
		} else
			System.out.println(k);

	}
}
