package DSA.Bucket3._02_strings;

public class _04_ReverseStr_Imp {

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