package DSA.Bucket2._01_arrays._04_slidingWindow;

import java.util.*;

//As longest window need to be calculated, when window condition breaks then no need to shrink because lesser valid window size has no significance 
public class _14_03_LongestRepeatingCharReplacement_Opt {

	public static int findLongestRepeatingCharReplacement(String str, int k) {

		int l = 0, maxFreq = 0, longestRepeatingChar = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();// O(26)

		for (int r = 0; r < str.length(); r++) { // O(N)

			hm.put(str.charAt(r), hm.getOrDefault(str.charAt(r), 0) + 1);
			maxFreq = Math.max(maxFreq, hm.get(str.charAt(r)));

			while (((r - l + 1) - maxFreq) > k) {
				hm.put(str.charAt(l), hm.get(str.charAt(l)) - 1);
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