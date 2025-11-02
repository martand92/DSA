package DSA.Bucket3._02_strings;

public class _16_LongestPalindromicSubString_Imp {

	public static boolean isPalindrome(String s, int i, int j) {

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

	public static String findSubstring(String s, int i, int j) {

		if (i > j)
			return "";

		if (i == j)
			return String.valueOf(s.charAt(i));

		if (s.charAt(i) == s.charAt(j)) {
			// if chars at i & j are same then repeat this check for inner substring.
			// When backtracking check if inner substring is palindrome, if yes then attach
			// current chars at i & j at both ends to inner palindromic substring
			String innerSubString = findSubstring(s, i + 1, j - 1);

			if (isPalindrome(s, i + 1, j - 1))
				return s.charAt(i) + innerSubString + s.charAt(j);
		}

		// else : try both options & pick longer subStr
		String left = findSubstring(s, i + 1, j);
		String right = findSubstring(s, i, j - 1);
		return left.length() > right.length() ? left : right;

	}

	public static void main(String[] args) throws Exception {
		String s = "geeksforgeeks";
		findSubstring(s, 0, s.length() - 1);
	}
}