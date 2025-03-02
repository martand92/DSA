package DSA.Bucket4._10_dynamicprogramming._12_String_LongestCommonSubSeq;

import java.util.Arrays;

public class _03_03_Tabulation_Print {

	public static String reverseString(String s) {

		if (s.length() == 1) {
			return s;
		}

		return reverseString(s.substring(1)) + s.charAt(0);
	}

	public static String longestSubSeq(String s1, String s2, int index1, int index2, int[][] dp) {

		for (int i = 1; i <= index1; i++) {
			for (int j = 1; j <= index2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		// dp[index1][index2];

		System.out.println(Arrays.deepToString(dp));

		String ans = new String();
		while (index1 > 0 && index2 > 0) {

			if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {

				ans += s1.charAt(index1 - 1);
				index1--;
				index2--;

			} else {

				if (dp[index1 - 1][index2] > dp[index1][index2 - 1])
					index1--;
				else
					index2--;

			}
		}

		return reverseString(ans);

	}

	public static void main(String[] args) {
		String s1 = "acd";
		String s2 = "ced";

		int[][] dp = new int[s1.length() + 1][s1.length() + 1];

		System.out.println(longestSubSeq(s1, s2, s1.length(), s2.length(), dp));
	}

}
