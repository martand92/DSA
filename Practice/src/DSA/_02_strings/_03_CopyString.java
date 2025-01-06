package DSA._02_strings;

//Using iterative & recursion
public class _03_CopyString {
	public static void main(String[] args) {
		String s1 = "geeksforgeeks";

		char[] s1Char = s1.toCharArray();
		char[] s2Char = new char[s1Char.length];

		// Using Iterative method
//		for (int i = 0; i < s1Char.length; i++) {
//			s2Char[i] = s1Char[i];
//		}

		// Using recursive method
		copyOfString(s1Char, s2Char, 0);

		System.out.println(String.valueOf(s2Char));
	}

	public static void copyOfString(char[] s1Char, char[] s2Char, int i) {

		if (i == s1Char.length)
			return;

		s2Char[i] = s1Char[i];
		copyOfString(s1Char, s2Char, i+1);

	}
}
