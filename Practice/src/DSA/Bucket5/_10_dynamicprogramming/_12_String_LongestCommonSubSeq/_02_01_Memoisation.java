package DSA.Bucket5._10_dynamicprogramming._12_String_LongestCommonSubSeq;

public class _02_01_Memoisation {

	public static int longestComnSubSeq(String s1, String s2, int index1, int index2, int[][] dp) {

		if (index1 == -1 || index2 == -1)
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		if (s1.charAt(index1) == s2.charAt(index2))
			return dp[index1][index2] = 1 + longestComnSubSeq(s1, s2, index1 - 1, index2 - 1, dp);

		return dp[index1][index2] = Math.max(longestComnSubSeq(s1, s2, index1 - 1, index2, dp),
				longestComnSubSeq(s1, s2, index1, index2 - 1, dp));
	}

	public static void main(String[] args) {
		String s1 = "acd";
		String s2 = "ced";

		int[][] dp = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++)
				dp[i][j] = -1;
		}

		System.out.println(longestComnSubSeq(s1, s2, s1.length() - 1, s2.length() - 1, dp));
	}

}
//TC : O(N * M)
//SC : O(N*M) + O(N + M)