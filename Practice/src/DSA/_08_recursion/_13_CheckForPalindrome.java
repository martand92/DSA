package DSA._08_recursion;

public class _13_CheckForPalindrome {

	public static void main(String[] args) {
		String str = "racecar";
		System.out.println(isPalindrome(str));
	}

	public static boolean isPalindrome(String str) {

		if (str.length() == 0 || str.length() == 1)
			return true;

		if (str.charAt(0) == str.charAt(str.length() - 1))
			return isPalindrome(str.substring(1, str.length() - 1));

		return false;
	}
}
