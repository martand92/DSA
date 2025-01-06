package DSA._10_dynamicprogramming._12_String_LongestCommonSubSeq;

public class _01_02_Recursion_Print {

	public static String longestComnSubSeq(String s1, String s2, int index1, int index2) {

		if (index1 == -1 || index2 == -1)
			return "";

		if (s1.charAt(index1) == s2.charAt(index2))
			return s1.charAt(index1) + longestComnSubSeq(s1, s2, index1 - 1, index2 - 1);

		String ans1 = longestComnSubSeq(s1, s2, index1 - 1, index2);
		String ans2 = longestComnSubSeq(s1, s2, index1, index2 - 1);
		return ans1 + ans2;
	}

	public static String reverseString(String str) {
		if (str.length() == 1)
			return str;

		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static void main(String[] args) {
		String s1 = "acd";
		String s2 = "ced";

		System.out.println(reverseString(longestComnSubSeq(s1, s2, s1.length() - 1, s2.length() - 1)));
	}

}
//TC : O(2^n * 2^m)
//SC : O(n+m)