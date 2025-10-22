package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/decode-the-pattern1138/1
public class _14_LookAndSayPattern_Imp {

	public static String lookAndSayPattern(int n, String str, int l) {
		if (n == 1)
			return str;

		String newStr = new String();
		for (int r = 0; r < str.length(); r++) {
			if (str.charAt(r) != str.charAt(l)) {
				newStr += String.valueOf(r - l) + str.charAt(l);
				l = r;
			}
		}

		newStr += String.valueOf(str.length() - l) + str.charAt(l);// last scenario
		return lookAndSayPattern(n - 1, newStr, 0);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(lookAndSayPattern(n, "1", 0));
	}

}