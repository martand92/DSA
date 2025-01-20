package DSA._10_dynamicprogramming._03_PickAndNotPick_MaxSumOfNonAdjEle;

public class _03_MaxSumOfNonAdjEle_Tabulation {

	public static int findMaxSumOfNonAdjEle(int[] arr, int n, int[] dp) {
		dp[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {

			int leftSum = 0;

			if (i > 1)
				leftSum = dp[i - 2] + arr[i];
			else
				leftSum = arr[i]; // if i==1 then dp[i-2] = dp[-1] which returns 0 and do + arr[i]

			int rightSum = dp[i - 1] + 0;

			dp[i] = Math.max(leftSum, rightSum);
		}

		return dp[arr.length - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[] dp = new int[arr.length];

		System.out.println(findMaxSumOfNonAdjEle(arr, 0, dp));
	}
}