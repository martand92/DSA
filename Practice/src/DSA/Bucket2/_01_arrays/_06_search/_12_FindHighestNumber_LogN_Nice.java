package DSA.Bucket2._01_arrays._06_search;

//https://practice.geeksforgeeks.org/problems/find-the-highest-number2259/1
public class _12_FindHighestNumber_LogN_Nice {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 };

		int l = 0, r = arr.length - 1;
//
//		while (l < r) {
//			int mid = l + (r - l) / 2;
//
//			if (arr[mid] > arr[mid + 1])
//				r = mid;
//			else
//				l = mid + 1;
//		}
//
//		System.out.println(arr[l]);

		if (arr[l] < arr[r])
			System.out.println(arr[r]);
		else {
			while (l <= r) {

				int mid = l + (r - l) / 2;

				if ((arr[mid] >= arr[mid + 1]) && (arr[mid] >= arr[mid - 1])) {
					System.out.println(arr[mid]);
					break;
				} else if (arr[mid] < arr[mid + 1])
					l = mid + 1;
				else
					r = mid - 1;
			}

		}

	}
}
