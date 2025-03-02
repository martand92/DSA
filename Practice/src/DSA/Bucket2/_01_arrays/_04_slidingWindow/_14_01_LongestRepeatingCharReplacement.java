package DSA.Bucket2._01_arrays._04_slidingWindow;

import java.util.*;

//https://www.youtube.com/watch?v=_eNhaDCr6P0
//https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class _14_01_LongestRepeatingCharReplacement {

	public static int findLongestRepeatingCharReplacement(String str, int k) {

		int l = 0, maxFreq = 0, longestRepeatingChar = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();// O(26)

		for (int r = 0; r < str.length(); r++) { // O(N)

			hm.put(str.charAt(r), hm.getOrDefault(str.charAt(r), 0) + 1);
			maxFreq = Math.max(maxFreq, hm.get(str.charAt(r)));

			// if there are more chars to be replaced than k then reduce window //O(N)
			while (((r - l + 1) - maxFreq) > k) {// r-l+1:window size, window size - max freq chars provides no of other
													// chars to be replaced. If they are <= k then fine but >k then need
													// to reduce window
				hm.put(str.charAt(l), hm.get(str.charAt(l)) - 1);

				// update max freq after removing lth char from window
				maxFreq = 0;// reset max freq
				for (Map.Entry<Character, Integer> e : hm.entrySet()) // O(26)
					maxFreq = Math.max(maxFreq, e.getValue()); // new max freq after shrinking window

				l++;
			}

			longestRepeatingChar = Math.max(longestRepeatingChar, r - l + 1);
		}

		return longestRepeatingChar;
	}

	public static void main(String[] args) {
		String str = "AABABBA";
		int k = 2;
		System.out.println(findLongestRepeatingCharReplacement(str, k));
	};
}

//TC : O(N) + O(N) * O(26)
//SC : O(26)