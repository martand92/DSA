package DSA.Bucket2._08_search._02_BinarySearch._05_BS;

//https://practice.geeksforgeeks.org/problems/balance-with-respect-to-an-array5443/1
public class _16_BalanceWRTArray_O_LogN {

	public static boolean isBalanced(int[] arr, int x, int l, int r) {

		while (l <= r) {

			int mid = (l + r) / 2;

			if (arr[mid] == x)
				return true;

			else if (arr[mid] < x)
				l = mid + 1;

			else
				r = mid - 1;
		}

		if (Math.abs(arr[r] - x) == Math.abs(arr[l] - x) || r < 0 || l > arr.length - 1)
			return true;

		return false;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
		int x = 5;

		System.out.println(isBalanced(arr, x, 0, arr.length - 1));
	}
}