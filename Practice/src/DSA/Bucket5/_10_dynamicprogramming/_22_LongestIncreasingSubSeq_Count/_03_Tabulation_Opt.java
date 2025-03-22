package DSA.Bucket5._10_dynamicprogramming._22_LongestIncreasingSubSeq_Count;

import java.util.Arrays;

//https://www.youtube.com/watch?v=cKVl1TFdNXg
//Need to understand this logic
public class _03_Tabulation_Opt {

	public static int countLIS(int[] arr) {

		int[] dp = new int[arr.length]; // Stores LIS length ending at index i
		int[] count = new int[arr.length]; // Stores number of LIS ending at index i

		Arrays.fill(dp, 1);// Every element is an LIS of length 1
		Arrays.fill(count, 1);// Each element forms a single LIS on its own

		int maxLIS = 1; // Track the maximum LIS length

		// First find LIS
		for (int curr = 1; curr < arr.length; curr++) { // O(n^2)

			for (int prev = 0; prev < curr; prev++) {

				if (arr[prev] < arr[curr]) {

					if (dp[curr] < dp[prev] + 1) {
						dp[curr] = dp[prev] + 1;
						count[curr] = count[prev];
						// Since this is the first time dp[curr] reaches this length, we reset
						// count[curr] to count[prev] because:
						// All LIS ending at prev can now contribute to curr, so their count is carried
						// forward.

					} else if (dp[curr] == dp[prev] + 1)// This means another LIS of the same length is found
						count[curr] += count[prev];// Instead of replacing count[curr], we add count[prev] because prev
													// contributes additional LIS paths of the same length
				}
			}

			maxLIS = Math.max(maxLIS, dp[curr]);
		}

		// Sum all LIS counts where LIS length is maxLIS
		int totalCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (dp[i] == maxLIS) {
				totalCount += count[i];
			}
		}

		return totalCount;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 11, 1, 16, 8 };
		System.out.println(countLIS(arr));
	}
}