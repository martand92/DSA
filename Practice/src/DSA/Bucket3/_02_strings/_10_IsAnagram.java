package DSA.Bucket3._02_strings;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/anagram-palindrome4720/1
public class _10_IsAnagram {

	public static boolean isAnagram(String str) {

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int count = 0;

		for (int i = 0; i < str.length(); i++)
			hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);

		for (Map.Entry<Character, Integer> e : hm.entrySet()) {
			if (e.getValue() % 2 != 0)
				count++;
		}

		// Characters with odd count should not be not more than 1
		return count <= 1;
	}

	public static void main(String[] args) {

		String S = "geeksogeeks";
		System.out.println(isAnagram(S));
	}
}