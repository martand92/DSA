package DSA.Bucket5._10_dynamicprogramming._12_String_LongestCommonSubSeq;

public class _01_01_Recursion {

	public static int longestComnSubSeq(String s1, String s2, int index1, int index2) {

		if (index1 == -1 || index2 == -1)
			return 0;

		if (s1.charAt(index1) == s2.charAt(index2))
			return 1 + longestComnSubSeq(s1, s2, index1 - 1, index2 - 1);

		return Math.max(longestComnSubSeq(s1, s2, index1 - 1, index2), longestComnSubSeq(s1, s2, index1, index2 - 1));
	}

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";

		System.out.println(longestComnSubSeq(s1, s2, s1.length() - 1, s2.length() - 1));
	}

}
//TC : O(2^n * 2^m)
//SC : O(n+m)