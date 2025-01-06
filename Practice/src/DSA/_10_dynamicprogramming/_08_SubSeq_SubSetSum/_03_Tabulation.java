package DSA._10_dynamicprogramming._08_SubSeq_SubSetSum;

import java.util.Arrays;

public class _03_Tabulation {

	public static boolean checkIfKSum(int[] arr, int k, boolean[][] dp) {

		// if (k == 0)
		// return true;

		for (int index = 0; index < arr.length; index++)
			dp[index][0] = true;

//		if (index == 0) {
//			if (k == arr[index])
//				return true;
//
//			return false;
//		}
		dp[0][arr[0]] = true;

		for (int index = 1; index < arr.length; index++) {

			for (int j = 0; j <= k; j++) {

//				boolean pick = false;
//				if (k >= arr[index])
//					pick = checkIfKSum(arr, k - arr[index], index - 1, dp);

//				boolean notPick = checkIfKSum(arr, k, index - 1, dp);

				boolean pick = false;
				if (j >= arr[index])
					pick = dp[index - 1][j - arr[index]];

				boolean notPick = dp[index - 1][j];

//				dp[index][k] = pick || notPick ? 1 : 0; // update dp[][] to 1 or 0 from -1 to indicate this index,k is visited
//				return pick || notPick;
				dp[index][j] = pick | notPick;
			}

		}

		return dp[arr.length - 1][k];

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 6;

		// directly writing dp as boolean instead of int
		boolean[][] dp = new boolean[arr.length][k + 1];
		for (int rows = 0; rows < arr.length; rows++)
			Arrays.fill(dp[rows], false);

		System.out.println(checkIfKSum(arr, k, dp));
	}
}