package DSA.Bucket5._10_dynamicprogramming._14_String_DistinctSubSeq;

public class _01_Recursion {

	public static int findDistinctSubSeq(String s1, String s2, int index1, int index2) {
		// here base case order matters
		if (index2 < 0)
			return 1;

		if (index1 < 0)
			return 0;

		if (s1.charAt(index1) == s2.charAt(index2)) {
			int countForConsider = findDistinctSubSeq(s1, s2, index1 - 1, index2 - 1);
			int countForNotConsider = findDistinctSubSeq(s1, s2, index1 - 1, index2);
			return countForConsider + countForNotConsider;
		} else
			return findDistinctSubSeq(s1, s2, index1 - 1, index2);

//		if (s1.charAt(index1) == s2.charAt(index2))
//			return findDistinctSubSeq(s1, s2, index1 - 1, index2 - 1) + findDistinctSubSeq(s1, s2, index1 - 1, index2);
//
//		return findDistinctSubSeq(s1, s2, index1 - 1, index2);
	}

	public static void main(String[] args) {
		String s1 = "babgbag";
		String s2 = "bag";

		System.out.println(findDistinctSubSeq(s1, s2, s1.length() - 1, s2.length() - 1));
	}

}
//TC : O(2^N * 2^M)
//SC : O(N+M)