package DSA.Bucket4._10_dynamicprogramming._20_LongestIncresingSubSeq_Length;

public class _02_Memoisation {

	public static int longestIncreasingSubSeq(int[] arr, int index, int prevIndex, int[][] dp) {

		if (index == arr.length)
			return 0;

		if (dp[index][prevIndex + 1] != -1) // mapping -1 coming from prevIndex to 0th index in dp
			return dp[index][prevIndex + 1];

		int pick = 0;
		if (prevIndex == -1 || (arr[prevIndex] - arr[index] < 0)) {
			pick = 1 + longestIncreasingSubSeq(arr, index + 1, index, dp);
		}

		int notPick = longestIncreasingSubSeq(arr, index + 1, prevIndex, dp);

		return dp[index][prevIndex + 1] = Math.max(pick, notPick);

	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[][] dp = new int[arr.length][arr.length + 1];// index and prevIndex are variables and in recursion prevIndex
															// has -1. To accommodate this need to shift prevIndex by 1

		for (int i = 0; i < arr.length; i++) // for index
			for (int j = 0; j <= arr.length; j++) // prevIndex from 0 -> n+1, as -1 to n was seen in recursion
				dp[i][j] = -1;

		System.out.println(longestIncreasingSubSeq(arr, 0, -1, dp));
	}

}

//TC : O(n * n)
//SC : O(n * n) + O(n)