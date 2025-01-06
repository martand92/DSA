package DSA._10_dynamicprogramming._16_String_WildcardMatching;

public class _01_Recursion {

	public static boolean isMatch(String s1, String s2, int index1, int index2) {

		if (index1 < 0 && index2 < 0) // when both strings are exhausted
			return true;

		if (index1 < 0 && index2 >= 0) // when only string1 is exhausted but not string2
			return false;

		if (index2 < 0 && index1 >= 0) { // when only string2 is exhausted, need to check if remaining string1 chars has
											// only *, if not then return false
			for (int i = 0; i <= index1; i++)
				if (s1.charAt(i) != '*')
					return false;

			return true;
		}

		if (s1.charAt(index1) == '*') {
			int count = 0;
			while (index2 >= 0) {
				if (isMatch(s1, s2, index1 - 1, index2 - count))
					return true;
				count++;
			}
			// if chars are matching or has ? then just move ahead
		} else if (s1.charAt(index1) == '?' || s1.charAt(index1) == s2.charAt(index2))
			return isMatch(s1, s2, index1 - 1, index2 - 1);

		else if (s1.charAt(index1) != s2.charAt(index2)) // if char doesn't match at any given pos then return false
			return false;

		return false;
	}

	public static void main(String[] args) {
		String s1;
		String s2;

//		s1 = "ab?d";
//		s2 = "abcd";
//
//		s1 = "ab*cd";
//		s2 = "abdefcd";
//
//		s1 = "*abcd";
//		s2 = "abcd";

		s1 = "ab?c";
		s2 = "abcd";

		System.out.println(isMatch(s1, s2, s1.length() - 1, s2.length() - 1));
	}

}
