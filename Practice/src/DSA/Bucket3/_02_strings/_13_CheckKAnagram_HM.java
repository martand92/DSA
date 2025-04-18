package DSA.Bucket3._02_strings;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1
public class _13_CheckKAnagram_HM {

	public static boolean checkIfKAnagram(String s1, String s2, int k) {

		if (s1.length() != s2.length())
			return false;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++)
			hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);

		for (int i = 0; i < s2.length(); i++) {

			Object val = hm.get(s2.charAt(i));

			if (val != null && (int) val != 0)
				hm.put(s2.charAt(i), (int) val - 1);
			else
				k--;

			if (k < 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {

		String s1 = "ukdbgygrsjlaukwsgc";
		String s2 = "memdwhetaewfahkc";
		int k = 14;

//		String s1 = "geeks";
//		String s2 = "eggkf";
//		int k = 2;

		System.out.println(checkIfKAnagram(s1, s2, k));

	}
}