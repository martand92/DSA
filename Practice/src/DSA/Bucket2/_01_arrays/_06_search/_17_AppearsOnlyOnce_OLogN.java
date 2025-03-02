package DSA.Bucket2._01_arrays._06_search;

//https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1

//All elements before the required element have the first occurrence at even index and next occurrence at odd index.
//All elements after the required element have the first occurrence at odd index and next occurrence at even index.

public class _17_AppearsOnlyOnce_OLogN {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65 };

		// O(LogN)
		int l = 0, r = arr.length - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
				System.out.println(arr[mid]);
				return;
			}

			else if (arr[mid] == arr[mid - 1]) {

				if (mid % 2 != 0)
					l = mid + 1;
				else
					r = mid - 1;

			} else if (arr[mid] == arr[mid + 1]) {

				if (mid % 2 == 0)
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
		// System.out.println(arr[l]);

		// O(N)
//		int num = 0;
//		for (int i = 0; i < arr.length; i++)
//			num ^= arr[i];
//
//		System.out.println(num);
	}

}
