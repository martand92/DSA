package DSA.Bucket3._02_strings;

public class _04_ReverseString_recursion {

	public static void main(String[] args) {
		String str = "martand";
		System.out.println(reverseString(str));
	}

	public static String reverseString(String str) {

		if (str.length() == 1)
			return str;

		String a = reverseString(str.substring(1)) + str.charAt(0);
		return a;
		
	}

}
