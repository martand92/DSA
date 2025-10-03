package DSA.Bucket2._05_slidingWindow;

import java.util.*;

//https://www.youtube.com/watch?v=-zSxTJkcdAo
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class _08_LongestSubStringWithoutRepeatingChars {

	public static int findLongestSubString_Hash(String s) {

		int l = 0, maxLength = 0, windowLength = 0;
		HashSet<Character> hs = new HashSet<Character>();

		for (int r = 0; r < s.length(); r++) { // O(N)

			// first check with increased right pointer if this character is already part of
			// current window, if yes then move left pointer till no duplicates are present
			while (hs.contains(s.charAt(r))) { // to check contains : O(log n)
				hs.remove(s.charAt(l)); // O(1)
				l++;
			}

			hs.add(s.charAt(r)); // O(1)
			windowLength = r - l + 1;

			maxLength = Math.max(maxLength, windowLength);
		}

		return maxLength;
		// TC: O(N) + O(log N)
		// SC: O(1)
	}

//	Example:
//		Suppose s = "hello" and r = 1.
//
//		s.charAt(r) would be 'e' (the character at index 1 in the string "hello").
//		The Unicode value of 'e' is 101 (in ASCII/Unicode).
//		The Unicode value of 'a' is 97 (in ASCII/Unicode).
//		So, s.charAt(r) - 'a' would be: 101 - 97 = 4
	public static int findLongestSubString_Array(String s) {

		int l = 0, maxLength = 0, windowLength = 0;
		int[] hash = new int[256];

		for (int r = 0; r < s.length(); r++) { // O(N)

			// this char is already in given window by checking through its ASCII
			while (hash[s.charAt(r) - 'a'] == 1) {
				hash[s.charAt(r) - 'a'] = 0; // O(1)
				l++;
			}

			hash[s.charAt(r) - 'a'] = 1; // O(1)
			windowLength = r - l + 1;

			maxLength = Math.max(maxLength, windowLength);
		}

		return maxLength;

		// TC: O(N), we are checking & accessing in O(1) for array unlike hash O(log n)
		// SC: O(1)
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Usig Hash : " + findLongestSubString_Hash(s));
		System.out.println("Usig Array : " + findLongestSubString_Array(s));
	}

}
