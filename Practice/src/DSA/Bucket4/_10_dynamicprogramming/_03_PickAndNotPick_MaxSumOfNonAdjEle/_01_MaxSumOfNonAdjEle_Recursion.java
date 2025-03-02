package DSA.Bucket4._10_dynamicprogramming._03_PickAndNotPick_MaxSumOfNonAdjEle;

public class _01_MaxSumOfNonAdjEle_Recursion {

	public static int findMaxSumOfNonAdjEle(int[] arr, int n) {

		if (n == 0)
			return arr[0];

		if (n < 0)
			return 0;

		int leftSum = findMaxSumOfNonAdjEle(arr, n - 2) + arr[n];
		int rightSum = findMaxSumOfNonAdjEle(arr, n - 1) + 0;

		return Math.max(leftSum, rightSum);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(findMaxSumOfNonAdjEle(arr, arr.length - 1));
	}
}