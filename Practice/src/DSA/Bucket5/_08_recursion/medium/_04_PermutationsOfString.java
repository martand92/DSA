package DSA.Bucket5._08_recursion.medium;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
public class _04_PermutationsOfString {

	public static void permutation(String s, int i, int j) {

		if (i == s.length() || j == s.length())
			return;

		if (i == s.length() - 1 && j == s.length() - 1) {
			System.out.println(s);
			return;
		}

		s = swap(s, i, j);

		// while doing depth traversal, i = i+1 & j = i
		permutation(s, i + 1, i + 1);

		// While switching branch, j = j + 1
		permutation(s, i, j + 1);

		// Unlike array no need to re-swap to revert back string as its swapping by
		// value

	}

//	public static String swap(String s, int i, int j) {
//
//		if (i == j)
//			return s;
//
//		return s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j) + s.charAt(i) + s.substring(j + 1);
//	}

	public static String swap(String s, int i, int j) {

		if (i != j) {

			char[] chars = s.toCharArray();

			chars[i] = (char) (chars[i] ^ chars[j]);
			chars[j] = (char) (chars[i] ^ chars[j]);
			chars[i] = (char) (chars[i] ^ chars[j]);

			return String.valueOf(chars);
		}

		return s;
	}

	public static void main(String[] args) {
		permutation("ABC", 0, 0);
	}
}