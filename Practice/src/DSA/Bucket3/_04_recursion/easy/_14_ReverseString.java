package DSA.Bucket3._04_recursion.easy;

public class _14_ReverseString {

	public static void main(String[] args) {
		String str = "martand";
		System.out.println(reverseString(str));
	}

	public static String reverseString(String str) {

		if (str.length() == 1)
			return str;

		return reverseString(str.substring(1)) + str.charAt(0);

	}

}
