package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/decode-the-pattern1138/1
public class _14_LookAndSayPattern {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(lookAndSayPattern(n, "1", "", 0, 0, 0));
	}

	public static String lookAndSayPattern(int n, String s, String newStr, int i, int j, int count) {
		if (n == 1)
			return s;

		while (j < s.length()) {

			if (s.charAt(i) == s.charAt(j))
				count++;

			else {
				newStr += String.valueOf(count) + s.charAt(i);
				i = j;
				count = 1;
			}

			j++;
		}

		newStr += String.valueOf(count) + s.charAt(i);// last scenario

		return lookAndSayPattern(n - 1, newStr, "", 0, 0, 0);// reset count, i, j
	}
}