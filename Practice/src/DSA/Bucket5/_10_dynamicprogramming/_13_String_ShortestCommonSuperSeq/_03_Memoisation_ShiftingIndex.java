package DSA.Bucket5._10_dynamicprogramming._13_String_ShortestCommonSuperSeq;

public class _03_Memoisation_ShiftingIndex {

	public static String reverse(String s) {

		if (s.length() == 1)
			return s;

		return reverse(s.substring(1)) + s.charAt(0);
	}

	public static String findShortestSuperSeq(String s1, String s2, int i, int j, String[][] dp) {

		if (i == 0)
			return s2.substring(0, j);

		if (j == 0)
			return s1.substring(0, i);

		if (dp[i][j] != null)
			return dp[i][j];

		if (s1.charAt(i - 1) == s2.charAt(j - 1))
			return dp[i][j] = s1.charAt(i - 1) + findShortestSuperSeq(s1, s2, i - 1, j - 1, dp);

		else {
			String str1 = s1.charAt(i - 1) + findShortestSuperSeq(s1, s2, i - 1, j, dp);
			String str2 = s2.charAt(j - 1) + findShortestSuperSeq(s1, s2, i, j - 1, dp);

			if (str1.length() < str2.length())
				return dp[i][j] = str1;
			else
				return dp[i][j] = str2;
		}
	}

	public static void main(String[] args) {
		String s1 = "brute";
		String s2 = "groot";

		String[][] dp = new String[s1.length() + 1][s2.length() + 1];
		System.out.println(reverse(findShortestSuperSeq(s1, s2, s1.length(), s2.length(), dp)));
	}

}
