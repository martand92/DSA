package DSA.Bucket3._04_recursion.easy;

public class _13_CheckForPalindrome {
	// same as String->_16_01_LongestPalindromicSubString
	public static boolean isPalindrome_Iterative(String str, int i, int j) {

		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

	public static boolean isPalindrome_Recursive(String str, int i, int j) {

		if (i > j)
			return true;

		if (str.charAt(i) == str.charAt(j))
			return isPalindrome_Recursive(str, i + 1, j - 1);

		return false;
	}

	public static void main(String[] args) {
		String str = "racecar";
		System.out.println(isPalindrome_Recursive(str, 0, str.length() - 1));
	}
}