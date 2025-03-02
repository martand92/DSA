package DSA.Bucket4._10_dynamicprogramming._12_String_LongestCommonSubSeq;

import java.util.Arrays;

public class _02_02_Memoisation_1BasedIndexing_ForTabulation {

	public static int longestComnSubSeq(String s1, String s2, int index1, int index2, int[][] dp) {

		// Since tabulation is all dp[][], we cannot have indices with negative numbers.
		// Hence need to consider index by right shifting or 1 based instead of 0.
		// i.e, str1 = acd will have pointer index1 from 1 to 3 instead of 0 to 2

		// if (index1 == -1 || index2 == -1)
		// return 0;

		// So above code will be updated as below
		if (index1 == 0 || index2 == 0)
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		// instead of comparing index1 & index2, now compare index1-1
		// & index2-1
		if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
			return 1 + longestComnSubSeq(s1, s2, index1 - 1, index2 - 1, dp);

		return dp[index1][index2] = Math.max(longestComnSubSeq(s1, s2, index1 - 1, index2, dp),
				longestComnSubSeq(s1, s2, index1, index2 - 1, dp));
	}

	public static void main(String[] args) {
		String s1 = "acd";
		String s2 = "ced";

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];// increase dp array size by 1
		for (int rows = 0; rows <= s1.length(); rows++) // And include it in defaulting
			Arrays.fill(dp[rows], -1);

		System.out.println(longestComnSubSeq(s1, s2, s1.length(), s2.length(), dp));// send index1 as 3 & index2 as 3
	}
}
//TC : O(N * M)
//SC : O(N*M) + O(N + M)