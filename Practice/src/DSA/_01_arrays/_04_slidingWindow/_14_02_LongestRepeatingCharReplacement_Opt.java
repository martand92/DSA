package DSA._01_arrays._04_slidingWindow;

import java.util.*;

// Previously after window condition is broken and while shrinking left is moved with recalculating new max freq
// Since we are find longest repeating chars, finding new max freq(which will either remain same or reduce) will continue to break window condition but doesnt affect answer
// ex: if current maxFreqCount was > k which will invalidate window size, so shrinking window by doing l++ will either keep maxFreqCount as same or reduces.
// Hence if we don't calculate new maxFreq the behaviour will remain same i.e, window condition continue to break till greater maxFreq is found than previous
// And maxFreqCount doesnt contribute to final ans of longestWindowSize too


//So there is no point to calculate maxFreqCount when window is broken as it will remain as is or decrease
public class _14_02_LongestRepeatingCharReplacement_Opt {

	public static int findLongestRepeatingCharReplacement(String str, int k) {

		int l = 0, maxFreq = 0, longestRepeatingChar = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();// O(26)

		for (int r = 0; r < str.length(); r++) { // O(N)

			hm.put(str.charAt(r), hm.getOrDefault(str.charAt(r), 0) + 1);
			maxFreq = Math.max(maxFreq, hm.get(str.charAt(r)));

			while (((r - l + 1) - maxFreq) > k) {
				hm.put(str.charAt(l), hm.get(str.charAt(l)) - 1);
				
				//Below step doesn't contribute to final ans
				//maxFreq = 0;
				//for (Map.Entry<Character, Integer> e : hm.entrySet())
				//	maxFreq = Math.max(maxFreq, e.getValue());

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

//TC : O(N) + O(N)
//SC : O(26)