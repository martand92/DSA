package DSA.Bucket3._02_strings;

//https://www.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1

/* Iterate over each word w in the dictionary
 * Check if w is a subsequence of S
 * Among those that match, return the longest one (and lexicographically smallest in case of tie)
 */

public class _17_LargestWordInDictionary {

	public static boolean isSubsequence(String word, String s) {

		int i = 0, j = 0;

		while (i < word.length() && j < s.length()) {

			// When chars match, do both i++ & j++
			if (word.charAt(i) == s.charAt(j))
				i++;

			j++;
		}

		return i == word.length();
	}

	public static String findLargestWord(String[] d, String s) {

		String result = "";

		for (String word : d) {
			if (isSubsequence(word, s)) {
				// If subsequence word length is of same length as current result then check for
				// lexicographically smaller
				if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0))
					result = word;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String[] d = { "ale", "apple", "monkey", "plea" };
		String s = "abpcplea";
		System.out.println(findLargestWord(d, s));
	}
}