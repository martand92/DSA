package DSA._01_arrays._06_search._04_BinarySearchAns.minofmax_maxofmin;

//https://www.youtube.com/watch?v=thUd_WJn6wk

//https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557
//https://www.naukri.com/code360/problems/largest-subarray-sum-minimized_7461751 --> similar problem

//This problem is same as prev allocate books
public class _28_PainterPaint_minofmax {

	public static int maxOfBoardUnitTime(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
			max = Math.max(max, arr[i]);

		return max;
	}

	public static int sumOfAllBoardsTime(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		return sum;
	}

	public static boolean isPossible(int[] arr, int noOfPainters, int minTimeTaken) {

		int initialTimeTaken = 0;

		for (int i = 0; i < arr.length; i++) {

			if ((initialTimeTaken + arr[i]) <= minTimeTaken)
				initialTimeTaken += arr[i];
			else {
				noOfPainters--;
				initialTimeTaken = arr[i];
			}
		}

		if (noOfPainters > 0)
			return true;
		else
			return false;
	}

	public static int minTimeTaken(int[] arr, int noOfPainters) {
		// the min time taken to paint a board by a painter will be the max unit of
		// board
		// the max time taken to paint a board will be sum of all board's units
		// hence l = max(arr[]) and r = sum(arr[])

		int l = maxOfBoardUnitTime(arr), r = sumOfAllBoardsTime(arr), mid = 0;

		while (l <= r) {
			mid = (l + r) / 2;

			if (isPossible(arr, noOfPainters, mid))
				r = mid - 1;
			else
				l = mid + 1;

		}
		return l;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		int k = 2;
		System.out.println(minTimeTaken(arr, k));
	}
}
