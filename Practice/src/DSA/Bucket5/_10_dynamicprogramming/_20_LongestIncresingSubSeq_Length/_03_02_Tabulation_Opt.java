package DSA.Bucket5._10_dynamicprogramming._20_LongestIncresingSubSeq_Length;

import java.util.Arrays;

//https://youtu.be/IFfYfonAFGc?list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&t=405
public class _03_02_Tabulation_Opt {

	public static int longestIncreasingSubSeq(int[] arr) {

		// Step 1:Declare dp of length n and initialized with 1 as all have subseq of
		// length atleast 1
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		// Step 2:for every curr index, check if there exist prev whose value is < curr
		for (int curr = 1; curr < arr.length; curr++) {

			for (int prev = 0; prev < curr; prev++) {

				// should update current LIS by 1 only if previous ele < curr ele
				if (arr[prev] < arr[curr])

					// update only if LIS of curr < LIS of prev+1
					dp[curr] = dp[curr] < (dp[prev] + 1) ? (dp[prev] + 1) : dp[curr];
			}
		}

		System.out.println(Arrays.toString(dp));

		// Step 3:Now dp[] stores LIS of each arr element at resp dp index, find max LIS
		int max = dp[0];
		for (int i = 1; i < dp.length; i++)
			max = Math.max(max, dp[i]);

		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 11, 1, 16, 8 };
		System.out.println(longestIncreasingSubSeq(arr));
	}

}

//TC : O(n * n)
//SC : O(n)