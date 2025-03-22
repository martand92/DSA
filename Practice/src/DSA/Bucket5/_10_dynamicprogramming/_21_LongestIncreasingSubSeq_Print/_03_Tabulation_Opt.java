package DSA.Bucket5._10_dynamicprogramming._21_LongestIncreasingSubSeq_Print;

import java.util.Arrays;

//https://youtu.be/IFfYfonAFGc
public class _03_Tabulation_Opt {

	public static int[] longestIncreasingSubSeq(int[] arr) {

		// Step 1:Declare dp[] to store LIS
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		// Step 2 : Declare index[] to hold chain of all prev indices that form LIS
		int[] index = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			index[i] = i;

		// Step 3:for every curr arr ele check if prev array elements are less than
		// current array element then update dp[curr]
		for (int curr = 1; curr < arr.length; curr++) {

			for (int prev = 0; prev < curr; prev++) {

				// should update current LIS by 1 only if previous array ele < curr array ele
				if (arr[prev] < arr[curr]) {

					// update only if LIS of curr < LIS of prev+1. Here this step is important to
					// get exact prev index
					if (dp[curr] < dp[prev] + 1) {
						dp[curr] = dp[prev] + 1;
						index[curr] = prev;
					}
				}
			}
		}

		// Step 4: find maximum LIS count in dp[]
		int maxi = 0, max = dp[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
				maxi = i;
			}
		}

		// Step 5 : Trace back indices stored in index[] from above LIS index
		int[] ansArr = new int[dp[maxi]];// final ans will have length of LIS
		int i = maxi; // start tracing back from last element of index[]
		int count = dp[maxi] - 1; // keeping count of loops

		while (count >= 0) {
			ansArr[count] = arr[i]; // storing original arr elements that forms part of LIS
			i = index[i];
			count--;
		}

		return ansArr;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 11, 1, 16, 8 };
		System.out.println(Arrays.toString(longestIncreasingSubSeq(arr)));
	}
}