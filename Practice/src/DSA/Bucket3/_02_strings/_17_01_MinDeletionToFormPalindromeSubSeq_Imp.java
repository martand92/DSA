package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1
//Algo : minDeletions = length of string - length of longest palindrome subsequence (LPS)
public class _17_01_MinDeletionToFormPalindromeSubSeq_Imp {

	public static int lenOfLPS(String s, int i, int j) {
		if (i > j)
			return 0;

		if (i == j)
			return 1;

		// if chars match then resulting subseq will have these 2 chars
		if (s.charAt(i) == s.charAt(j))
			return 2 + lenOfLPS(s, i + 1, j - 1);
		else
			return Math.max(lenOfLPS(s, i + 1, j), lenOfLPS(s, i, j - 1));

	}

	public static void main(String[] args) {

		String s = "aebcbda";
		// String s = "aba";

		System.out.println(s.length() - lenOfLPS(s, 0, s.length() - 1));
	}
}

//Note: Here end result palindrome is also subSeq and not subString. So check if min deletion question is for subSeq or subString