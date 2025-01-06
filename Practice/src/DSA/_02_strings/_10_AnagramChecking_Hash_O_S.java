package DSA._02_strings;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/anagram-palindrome4720/1
public class _10_AnagramChecking_Hash_O_S {
	public static void main(String[] args) {

		String S = "geeksogeeks";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int count = 0;

		for (int i = 0; i < S.length(); i++)
			hm.put(S.charAt(i), hm.getOrDefault(S.charAt(i), 0) + 1);

		for (Map.Entry<Character, Integer> e : hm.entrySet()) {
			if (e.getValue() % 2 != 0)
				count++;
		}

		// Of all characters in given String, not more than 1 char's count should be odd
		// to make it Anagram
		if (count > 1)
			System.out.println(0);
		else
			System.out.println(1);
	}
}
