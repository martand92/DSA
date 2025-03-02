package DSA.Bucket4._10_dynamicprogramming._14_String_DistinctSubSeq;

import java.util.Arrays;

public class _02_02_Memoisation_1BasedIndexing_ForTabulation {

	public static int findDistinctSubSeq(String s1, String s2, int index1, int index2, int[][] dp) {
		// here base case order matters
		if (index2 == 0)
			return 1;

		if (index1 == 0)
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
			int countForConsider = findDistinctSubSeq(s1, s2, index1 - 1, index2 - 1, dp);
			int countForNotConsider = findDistinctSubSeq(s1, s2, index1 - 1, index2, dp);
			return dp[index1][index2] = countForConsider + countForNotConsider;
		} else
			return dp[index1][index2] = findDistinctSubSeq(s1, s2, index1 - 1, index2, dp);
	}

	public static void main(String[] args) {
		String s1 = "babgbag";
		String s2 = "bag";
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for (int rows = 0; rows <= s1.length(); rows++)
			Arrays.fill(dp[rows], -1);

		System.out.println(findDistinctSubSeq(s1, s2, s1.length(), s2.length(), dp));
	}

}
//TC : O(N * M)
//SC : O(N * M) for dp array + O(N+M) for stack space