package DSA._10_dynamicprogramming._16_String_WildcardMatching;

public class _02_Memoisation_ForTabulation {

	public static boolean isMatch(String s1, String s2, int index1, int index2, int[][] dp) {

		if (index1 == 0 && index2 == 0) // when both strings are exhausted
			return true;

		if (index1 == 0 && index2 >= 1) // when only string1 is exhausted but not string2
			return false;

		if (index2 == 0 && index1 >= 1) { // when only string2 is exhausted, need to check if remaining string1 chars
											// has only *, if not then return false
			for (int i = 1; i <= index1; i++)
				if (s1.charAt(i - 1) != '*')
					return false;

			return true;
		}

		if (dp[index1][index2] != -1)
			return dp[index1][index2] == 0 ? false : true;

		if (s1.charAt(index1 - 1) == '*') {

			int count = 0;

			while (index2 >= 0) {

				if (isMatch(s1, s2, index1 - 1, index2 - count, dp)) {
					dp[index1][index2] = 1;
					return true;
				}
				count++;
			}

			// if chars are matching or has ? then just move ahead
		} else if (s1.charAt(index1 - 1) == '?' || s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
			return isMatch(s1, s2, index1 - 1, index2 - 1, dp);

		else if (s1.charAt(index1 - 1) != s2.charAt(index2 - 1)) { // if char doesn't match at any given pos then return
																	// false
			dp[index1][index2] = 0;
			return false;
		}

		dp[index1][index2] = 0;
		return false;
	}

	public static void main(String[] args) {
		String s1;
		String s2;

//		s1 = "ab?d";
//		s2 = "abcd";
//
//		s1 = "ab*cd";
//		s2 = "abdefcd";
//
//		s1 = "*abcd";
//		s2 = "abcd";

		s1 = "ab?c";
		s2 = "abcd";

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++)
			for (int j = 0; j <= s2.length(); j++)
				dp[i][j] = -1;

		System.out.println(isMatch(s1, s2, s1.length(), s2.length(), dp));
	}

}
