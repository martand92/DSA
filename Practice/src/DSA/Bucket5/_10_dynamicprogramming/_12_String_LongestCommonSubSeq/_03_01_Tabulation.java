package DSA.Bucket5._10_dynamicprogramming._12_String_LongestCommonSubSeq;

import java.util.Arrays;

public class _03_01_Tabulation {

	public static int longestSubSeq(String s1, String s2, int index1, int index2, int[][] dp) {

		// no need to write below for loops as they are defaulted to 0
		for (int j = 0; j <= index2; j++)
			dp[0][j] = 0; // if (index1 == 0) return 0;

		for (int i = 0; i <= index1; i++)
			dp[i][0] = 0; // if (index2 == 0) return 0;

		for (int i = 1; i <= index1; i++) {

			for (int j = 1; j <= index2; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

			}
		}

		System.out.println(Arrays.deepToString(dp));
		return dp[index1][index2];

	}

	public static void main(String[] args) {
		String s1 = "acd";
		String s2 = "ced";

		int[][] dp = new int[s1.length() + 1][s1.length() + 1];
		System.out.println(longestSubSeq(s1, s2, s1.length(), s2.length(), dp));
	}

}
