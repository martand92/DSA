package DSA.Bucket3._02_strings;

//Note : This is not substring but subsequence, hence resulting palindromic sub seq need not be consecutive
public class _15_01_LongestPalindromicSubSeq_Imp {

	public static String findLPS(String s, int i, int j) {

		if (i > j)
			return "";

		if (i == j)
			return String.valueOf(s.charAt(i)); // single char is also palindrome

		if (s.charAt(i) == s.charAt(j))
			return s.charAt(i) + findLPS(s, i + 1, j - 1) + s.charAt(j);// result will be s[i] + further compute + s[j]

		// else : try both options & pick longer subseq
		String left = findLPS(s, i + 1, j);
		String right = findLPS(s, i, j - 1);
		return left.length() > right.length() ? left : right;

	}

	public static void main(String[] args) throws Exception {
		String s = "geeksforgeeks";
		System.out.println(findLPS(s, 0, s.length() - 1));
	}
}

//TC : O(2^n), SC : O(n)