package DSA.Bucket2._03_hash.Medium;

import java.util.*;

//https://www.youtube.com/watch?v=qtVh-XEpsJo

// Intuition : while moving char by char, check if curr char is already present in current substring using hashset in O(1).
// if not present then add it to hashset to indicate it forms part of substring
// if already present then this char's previous instance should be removed to consider current char
public class _07_LongestSubStringWithoutRepeatingChars {

	public static int findLongestSubString(String str) {

		HashSet<Character> hs = new HashSet<Character>();
		int maxLen = 0, l = 0;

		for (int r = 0; r < str.length(); r++) { // O(N)

			while (hs.contains(str.charAt(r))) { // O(N)
				hs.remove(str.charAt(l));
				l++;
			}

			hs.add(str.charAt(r));
			maxLen = Math.max(maxLen, (r - l + 1));
		}

		return maxLen;
	}

	public static void main(String[] args) {
		String str = "abcaabcdba";
		System.out.println(findLongestSubString(str));
	}
}

//TC : O(N) + O(N) ~ O(2N)