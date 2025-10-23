package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1
public class _17_02_MinDeletionForPalindrome_DP {

	public static void main(String[] args) {

		String s = "aebcbda";
		// String s = "aba";
		System.out.println(minNumOfDeletions(s, 0, s.length() - 1));
	}

	public static int minNumOfDeletions(String s, int i, int j) {

		if (i == j || i > j)
			return 0;

		// if char at i & j doesn't match, either delete i char or j char from String
		if (s.charAt(i) != s.charAt(j))
			return Math.min(minNumOfDeletions(s, i + 1, j) + 1, minNumOfDeletions(s, i, j - 1) + 1);
		else
			return minNumOfDeletions(s, i + 1, j - 1);
	}

}