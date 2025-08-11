package DSA.Bucket2._04_hash;

import java.util.*;

//Same logic as DSA.Strings._09_Isomorphic
//https://practice.geeksforgeeks.org/problems/match-specific-pattern/1
public class _15_MatchSpecificPattern_O_NK {

	public static void main(String[] args) {
		ArrayList<String> dict = new ArrayList<String>();
		dict.add("abb");
		dict.add("abc");
		dict.add("xyz");
		dict.add("xyyx");

		String pattern = "foof";
		String givenPattern = getPattern(pattern);
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < dict.size(); i++) {
			if (givenPattern.equals(getPattern(dict.get(i))))
				al.add(dict.get(i));
		}

		System.out.println(al);
	}

	public static String getPattern(String pattern) {

		String patternStr = "";

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		// Assign 0 -> n for different variables
		for (int i = 0; i < pattern.length(); i++) {
			if (!hm.containsKey(pattern.charAt(i)))
				hm.put(pattern.charAt(i), i);
		}

		// based on above digit reference form pattern
		for (int i = 0; i < pattern.length(); i++)
			patternStr += hm.get(pattern.charAt(i));

		return patternStr;
	}

}
