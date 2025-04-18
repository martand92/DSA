package DSA.Bucket3._02_strings;

public class _15_LongestPalindromeSubSeq {

	public static void main(String[] args) throws Exception {
		String s = "geeksforgeeks";
		System.out.println(findLPS(s, 0, s.length() - 1));
	}

	public static String findLPS(String s, int i, int j) {

		if (i > j)
			return "";

		if (i == j)
			return s.charAt(i) + ""; // single character is a palindrome

		if (s.charAt(i) == s.charAt(j)) {
			// Match → wrap result with s[i] and s[j]
			return s.charAt(i) + findLPS(s, i + 1, j + 1) + s.charAt(j);

		} else {
			// No match → try both options and pick the longer one
			String left = findLPS(s, i + 1, j);
			String right = findLPS(s, i, j - 1);
			return left.length() > right.length() ? left : right;
		}

	}

}