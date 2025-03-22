package DSA.Bucket5._10_dynamicprogramming._13_String_ShortestCommonSuperSeq;

public class _02_Memoisation {

	public static String reverse(String s) {

		if (s.length() == 1)
			return s;

		return reverse(s.substring(1)) + s.charAt(0);
	}

	public static String findShortestSuperSeq(String s1, String s2, int i, int j, String[][] dp) {

		// when 1 of the index is exhausted pick all the remaining chars from other
		// string from 0->index
		if (i < 0)
			return s2.substring(0, j + 1);

		if (j < 0)
			return s1.substring(0, i + 1);

		if (dp[i][j] != null)
			return dp[i][j];

		// if chars are matching have it as final subseq and move both i & j
		if (s1.charAt(i) == s2.charAt(j))
			return dp[i][j] = s1.charAt(i) + findShortestSuperSeq(s1, s2, i - 1, j - 1, dp);

		// if chars are not matching then, need to check shortest resulting subseq by
		// having both of them

		// if considering char at i as part of subseq then move i pointer else if
		// considering char
		// at j then move j pointer
		else {
			String str1 = s1.charAt(i) + findShortestSuperSeq(s1, s2, i - 1, j, dp);
			String str2 = s2.charAt(j) + findShortestSuperSeq(s1, s2, i, j - 1, dp);

			// consider the shortest of above subsequences
			if (str1.length() < str2.length())
				return dp[i][j] = str1;
			else
				return dp[i][j] = str2;
		}
	}

	public static void main(String[] args) {
		String s1 = "brute";
		String s2 = "groot";

		String[][] dp = new String[s1.length()][s2.length()];// here dp[][] is storing String
		// as you are traversing from end -> start need to reverse final subseq formed
		System.out.println(reverse(findShortestSuperSeq(s1, s2, s1.length() - 1, s2.length() - 1, dp)));
	}

}
