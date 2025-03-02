package DSA.Bucket4._10_dynamicprogramming._21_LongestIncreasingSubSeq_Print;

import java.util.Arrays;

//https://youtu.be/IFfYfonAFGc?list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&t=1046
public class _03_Tabulation_From_OptimizedLIS {

	public static int[] longestIncreasingSubSeq(int[] arr) {

		// Step 1:Declare dp[] of length n and initialized with 1
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		// Step 2 : Declare index[] of length n and initialize with its own index
		int[] index = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			index[i] = i;

		// Step 3:for every current index, check if there exists previous array element
		// whose value is < current array element
		for (int ind = 1; ind < arr.length; ind++) {

			for (int prev = 0; prev < ind; prev++) {

				// should update current LIS by 1 only if previous array ele < curr array ele
				if (arr[prev] < arr[ind]) {

					// update only if LIS of curr < LIS of prev+1
					if (dp[ind] < (dp[prev] + 1)) {
						dp[ind] = dp[prev] + 1;
						index[ind] = prev;
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