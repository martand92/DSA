package DSA.Bucket5._10_dynamicprogramming._13_String_ShortestCommonSuperSeq;

public class _04_Tabulation {

	public static String reverse(String s) {

		if (s.length() == 1)
			return s;

		return reverse(s.substring(1)) + s.charAt(0);
	}

	public static String findShortestSuperSeq(String s1, String s2, int i, int j, String[][] dp) {

//		if (i == 0)
//			return s2.substring(0, j);
		for (int j1 = 0; j1 <= j; j1++)
			dp[0][j1] = s2.substring(0, j1);

//		if (j == 0)
//			return s1.substring(0, i);
		for (int i1 = 0; i1 <= i; i1++)
			dp[i1][0] = s1.substring(0, i1);

//		if (s1.charAt(i - 1) == s2.charAt(j - 1))
//			return dp[i][j] = s1.charAt(i - 1) + findShortestSuperSeq(s1, s2, i - 1, j - 1, dp);
//
//		else {
//			String str1 = s1.charAt(i - 1) + findShortestSuperSeq(s1, s2, i - 1, j, dp);
//			String str2 = s2.charAt(j - 1) + findShortestSuperSeq(s1, s2, i, j - 1, dp);
//
//			if (str1.length() < str2.length())
//				return dp[i][j] = str1;
//			else
//				return dp[i][j] = str2;
//		}

		for (int i1 = 1; i1 <= i; i1++) {

			for (int j1 = 1; j1 <= j; j1++) {

				if (s1.charAt(i1 - 1) == s2.charAt(j1 - 1))
					dp[i1][j1] = s1.charAt(i1 - 1) + dp[i1 - 1][j1 - 1];

				else {
					String str1 = s1.charAt(i1 - 1) + dp[i1 - 1][j1];
					String str2 = s2.charAt(j1 - 1) + dp[i1][j1 - 1];

					if (str1.length() < str2.length())
						dp[i1][j1] = str1;
					else
						dp[i1][j1] = str2;
				}

			}

		}

		return dp[s1.length()][s2.length()];

	}

	public static void main(String[] args) {
		String s1 = "brute";
		String s2 = "groot";

		String[][] dp = new String[s1.length() + 1][s2.length() + 1];
		System.out.println(reverse(findShortestSuperSeq(s1, s2, s1.length(), s2.length(), dp)));
	}

}
