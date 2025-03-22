package DSA.Bucket5._10_dynamicprogramming._16_String_WildcardMatching;

public class _03_Tabulation {

	public static boolean isMatch(String s1, String s2, int index1, int index2) {

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

		dp[0][0] = true;

		for (int indx2 = 1; indx2 <= index2; indx2++)
			dp[0][indx2] = false;

		for (int indx1 = 1; indx1 <= index1; indx1++) {

			for (int i = 1; i <= indx1; i++) {

				if (s1.charAt(i - 1) != '*')
					dp[indx1][0] = false;
				else

					dp[indx1][0] = true;
			}
		}

		for (int i = 1; i <= index1; i++) {

			for (int j = 1; j <= index2; j++) {

				if (s1.charAt(i - 1) == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

				else if (s1.charAt(i - 1) == '?' || s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];

				else if (s1.charAt(i - 1) != s2.charAt(j - 1))
					dp[i][j] = false;

				else
					dp[i][j] = false;
			}
		}

		return dp[index1][index2];

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

//		s1 = "ab?c";
//		s2 = "abcd";

		s1 = "a*b*c";
		s2 = "abc";

		System.out.println(isMatch(s1, s2, s1.length(), s2.length()));
	}

}
