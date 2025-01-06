package DSA._01_arrays._06_search;

//https://practice.geeksforgeeks.org/problems/balance-with-respect-to-an-array5443/1
public class _16_BalanceWRTArray_O_LogN {

	public static void main(String[] args) {

		int[] a = { 1, 2, 8, 10, 10, 12, 19 };
		int x = 5, l = 0, r = a.length - 1;
		String isBalanced = "Balanced";

		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;

			if (x == a[mid])
				break;
			else if (x < a[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}

		if (l < r) // if found the required balancing number in array then its intrinsic balanced
			System.out.println(isBalanced);

		if (r < 0) // "If one of floor or ceil does not exist assume 'x' to be balanced"
			System.out.println(isBalanced);

		else {
			if (Math.abs(a[l] - x) == Math.abs(a[r] - x))
				System.out.println(isBalanced);
			else {
				isBalanced = "Not Balanced";
				System.out.println(isBalanced);
			}
		}

	}

}
