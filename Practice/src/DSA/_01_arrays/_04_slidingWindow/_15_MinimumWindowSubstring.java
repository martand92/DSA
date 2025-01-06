package DSA._01_arrays._04_slidingWindow;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/description/
//https://www.youtube.com/watch?v=WJaij9ffOIY

// Algo : As need to find minimum subString, need to look for all characters in target string to be found in original string.
// till all the chars are not found, continue to increase r and expan window. Once all char are found then start decreasing l till minimum length is found
// While decreasing if any of the character goes out of window, then again start increasing r
public class _15_MinimumWindowSubstring {

	public static int findMinWindowSubString(String s, String t) {

		// Here count represents if all the characters in provided string are available
		// in current window as per target string
		int l = 0, minLength = Integer.MAX_VALUE, count = 0;

		// Store freq of character appearing in original string
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		// Store initial freq of chracters appeared in target string
		int[] initialTargetFreqHash = new int[26]; // represents target's freq initial value

		// Store target chracters freq in both hashmap and hash initial hash array.
		// Hashmap freq is updated with values appearing in original array
		// hash array will always contain target character freq to check fo window
		// condition and other operations
		for (int i = 0; i < t.length(); i++) {
			hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
			initialTargetFreqHash[t.charAt(i) - 'a']++;
		}

		for (int r = 0; r < s.length(); r++) {

			// Only add characters to hashmap that are seen in target string t, other
			// characters will be discarded

			if (hm.containsKey(s.charAt(r))) {

				// And also increase count whenever character in String s is seen for first time
				// as per target string's character

				// this count is important to check if all the characters from target string t
				// are seen in s
				if (hm.get(s.charAt(r)) == initialTargetFreqHash[s.charAt(r) - 'a'])
					count++;

				hm.put(s.charAt(r), hm.get(s.charAt(r)) + 1);
			}

			// Once in current window if all characters are see of target String t, now as
			// need to find min length start shrnking window till all target characters
			// continue to be part of window
			while (count == t.length()) {

				// continue to find min window contains all characters as target
				minLength = Math.min(minLength, r - l + 1);

//				if (!hm.containsKey(s.charAt(l)))
//					l++;

				if (hm.containsKey(s.charAt(l))) {

					// Once last target's character is found in current window, which will be
					// removed after further shrinking(l++), reduce count, decrease window(l++) and
					// break
					if (hm.get(s.charAt(l)) == initialTargetFreqHash[s.charAt(l) - 'a'] + 1) {
						// hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
						count--;

					} // else if (hm.get(s.charAt(l)) > initialTargetFreqHash[s.charAt(l) - 'a'] + 1)
						// {
						// hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
						// l++;
						// }

					hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
				}

				l++;

			}
		}

		return minLength;

	}

	public static void main(String[] args) {
		String s = "ddaaabbca";
		String t = "abc";

//		String s = "ADOBECODEBANC";
//		String t = "ABC";
		System.out.println(findMinWindowSubString(s.toLowerCase(), t.toLowerCase()));// converting to lowercase to apply
																						// algo for both cases
	}

}
