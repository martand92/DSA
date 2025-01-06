package DSA._08_recursion;

public class _15_ReverseString {

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
