package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/decode-the-pattern1138/1
public class _14_LookAndSayPattern {

	public static void main(String[] args) {
		int n = 6;

		String s = "1";

		s = lookAndSayPattern(n, s);
		System.out.println(s);

	}

	public static String lookAndSayPattern(int n, String s) {
		if (n == 1) {
			return s;
		}

		s = generatePattern(s, "");
		return lookAndSayPattern(n - 1, s);
	}

	public static String generatePattern(String s, String newStr) {

		int count = 0, i = 0, j = 0;

		while (j < s.length()) {

			if (s.charAt(i) == s.charAt(j))
				count++;

			else {
				newStr += String.valueOf(count) + s.charAt(i);
				i = j;
				count = 1;
			}

			if (j == s.length() - 1)
				newStr += String.valueOf(count) + s.charAt(i);

			j++;
		}

		return newStr;
	}
}
