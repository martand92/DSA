package DSA.Bucket5._10_dynamicprogramming._20_LongestIncresingSubSeq_Length;

import java.util.Arrays;

//https://youtu.be/IFfYfonAFGc
public class _03_02_Tabulation_Opt {

	public static int longestIncreasingSubSeq(int[] arr) {

		// Step 1:Declare dp of length n and initialized with 1 as all have subseq of
		// length atleast 1
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		int maxLIS = 1;

		// Step 2:for every curr index, check if there exist prev whose value is < curr
		for (int curr = 1; curr < arr.length; curr++) {

			for (int prev = 0; prev < curr; prev++) {

				// should update current LIS by 1 only if previous ele < curr ele
				if (arr[prev] < arr[curr])

					// Update only if currLIS < prevLIS + 1
					// This only avoid unnecessary update when dp[curr] > dp[prev] + 1. This check
					// can be skipped.
					// You can just do dp[curr] = dp[prev] + 1;

					dp[curr] = Math.max(dp[curr], dp[prev] + 1);
			}

			maxLIS = Math.max(maxLIS, dp[curr]);// update maxLIS if currentLIS is greater
		}

		return maxLIS;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 11, 1, 16, 8 };
		System.out.println(longestIncreasingSubSeq(arr));
	}
}

//TC : O(n * n)
//SC : O(n)