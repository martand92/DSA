package DSA.Bucket5._10_dynamicprogramming._10_SubSeq_CoinChange_InfiniteSupply;

public class _03_Tabulation {

	public static int countCoins(int[] arr, int target, int[][] dp) {

		for (int index = 0; index < arr.length; index++)
			dp[index][0] = 1;

		for (int i = 0; i <= target; i++) {
			if (i % arr[0] == 0)
				dp[0][i] = 1;
		}

		for (int index = 1; index < arr.length; index++) {

			for (int j = 0; j <= target; j++) {

				int pick = 0;
				if (j >= arr[index])
					pick = dp[index][j - arr[index]];

				int notPick = dp[index - 1][j];

				dp[index][j] = pick + notPick;
			}
		}

		return dp[arr.length - 1][target];

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int target = 4;

		int[][] dp = new int[arr.length][target + 1];

		System.out.println(countCoins(arr, target, dp));
	}

}
