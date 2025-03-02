package DSA.Bucket4._10_dynamicprogramming._08_SubSeq_SubSetSum;

import java.util.Arrays;

public class _02_Memoisation {

	public static boolean checkIfKSum(int[] arr, int k, int index, int[][] dp) {

		if (k == 0)
			return true;

		if (index == 0) {
			if (k == arr[index])
				return true;

			return false;
		}

		if (dp[index][k] != -1)
			return dp[index][k] == 0 ? false : true;// check if state(index, k) is visited, and if its

		boolean pick = false;
		if (k >= arr[index])
			pick = checkIfKSum(arr, k - arr[index], index - 1, dp);

		boolean notPick = checkIfKSum(arr, k, index - 1, dp);

		dp[index][k] = pick || notPick ? 1 : 0; // update dp[][] to 1 (if seq with sum is found) or 0 (if seq with
												// sum is notFound) from -1 to indicate state(index,k) is visited
		return pick || notPick;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		int k = 6;

		// Note : here dp is not boolean, because we need to identify if state is
		// visited as unvisited state will be -1
		int[][] dp = new int[arr.length][k + 1];
		for (int rows = 0; rows < arr.length; rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(checkIfKSum(arr, k, arr.length - 1, dp));
	}
}