package DSA._08_recursion.medium;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
public class _04_PermutationsOfString {

	public static void permutation(String s, int i, int j) {

		if (i == s.length() || j == s.length())
			return;

		s = swap(s, i, j);

		// while doing depth traversal, i = i+1 & j = i
		permutation(s, i + 1, i + 1);

		// While switching branch, j = j + 1
		permutation(s, i, j + 1);

		// Unlike array no need to revert back by swapping again as string swaps by
		// value

		// Print leaf node in tree
		if (i == s.length() - 1)
			System.out.println(s);

	}

	public static String swap(String s, int i, int j) {

		if (i == j)
			return s;

		char a = s.charAt(i);
		char b = s.charAt(j);

		return s.substring(0, i) + b + s.substring(i + 1, j) + a + s.substring(j + 1);
	}

	public static void main(String[] args) {
		permutation("ABC", 0, 0);
	}

}
