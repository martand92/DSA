package DSA.Bucket3._02_strings;

public class _16_01_LongestPalindromicSubString_Imp {

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

			String innerSubString = findSubstring(s, i + 1, j - 1);

			// When backtracking check if inner substring is palindrome, if yes then attach
			// current chars at i & j on both ends making string from i -> j palindrome
//			if (isPalindrome(s, i + 1, j - 1))
//				return s.charAt(i) + innerSubString + s.charAt(j);

			// Instead of calculating above palindrome again, just check

			/*
			 * If inner is EXACTLY the substring from i+1 to j-1 then its a palindrome
			 * 
			 * If i=0 & j=5 then innerString if palinfrome will be from i=1 to j=4 So inner
			 * String length(1->4) is 4 = j(5) - i(0) - 1. If innerSubString is full
			 * substring then its also palindrome
			 * 
			 * If innerSubString was not palindrome then its length will be shorter than
			 * j-i-1 as in both left and right scenarios it tries (i+2, j-1) or (i+1, j-2)
			 * 
			 */
			if (innerSubString.length() == (j - i - 1)) {
				return s.charAt(i) + innerSubString + s.charAt(j);
			}

		}

		// else : try both options & pick longer subStr
		String left = findSubstring(s, i + 1, j);
		String right = findSubstring(s, i, j - 1);
		return left.length() > right.length() ? left : right;

	}

	public static void main(String[] args) throws Exception {
		// String s = "geeksforgeeks";
		String s = "baabcc";
		System.out.println(findSubstring(s, 0, s.length() - 1));
	}
}

//TC : O(2^n), SC:O(n)