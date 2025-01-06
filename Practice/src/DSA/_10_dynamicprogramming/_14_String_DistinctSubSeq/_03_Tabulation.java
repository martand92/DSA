package DSA._10_dynamicprogramming._14_String_DistinctSubSeq;

public class _03_Tabulation {

	public static int findDistinctSubSeq(String s1, String s2, int index1, int index2, int[][] dp) {
		// here base case order matters
//		if (index2 == 0)
//			return 1;
//
//		if (index1 == 0)
//			return 0;

		for (int i = 0; i <= s1.length(); i++)
			dp[i][0] = 1;

		// you can ommit below loop as well because by default grid is initialized with
		// 0s
		for (int j = 1; j <= s2.length(); j++)// you need to start j with 1 as j = 0 is handled in previous for()
			dp[0][j] = 0;

//		if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
//			int countForConsider = findDistinctSubSeq(s1, s2, index1 - 1, index2 - 1, dp);
//			int countForNotConsider = findDistinctSubSeq(s1, s2, index1 - 1, index2, dp);
//			return dp[index1][index2] = countForConsider + countForNotConsider;
//		} else
//			return dp[index1][index2] = findDistinctSubSeq(s1, s2, index1 - 1, index2, dp);

		for (int i = 1; i <= s1.length(); i++) {

			for (int j = 1; j <= s2.length(); j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int countForConsider = dp[i - 1][j - 1];
					int countForNotConsider = dp[i - 1][j];
					dp[i][j] = countForConsider + countForNotConsider;

				} else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[index1][index2];

	}

	public static void main(String[] args) {
		String s1 = "babgbag";
		String s2 = "bag";
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++)
				dp[i][j] = -1;
		}

		System.out.println(findDistinctSubSeq(s1, s2, s1.length(), s2.length(), dp));
	}

}
