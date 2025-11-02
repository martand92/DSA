package DSA.Bucket3._02_strings;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1
public class _13_CheckKAnagram_Imp {

	public static boolean checkIfKAnagram_(String s1, String s2, int k) {

		if (s1.length() != s2.length())
			return false;

		StringBuilder str1 = new StringBuilder(s1);// O(n)

		for (int i = 0; i < s2.length(); i++) {

			int index = str1.indexOf(String.valueOf(s2.charAt(i)));// O(n)

			if (index >= 0)
				str1.deleteCharAt(index);// O(n)
		}

		if (str1.length() <= k)
			return true;

		return false;
	} // TC : O(n^2), SC : O(n)

	public static boolean checkIfKAnagram(String s1, String s2, int k) {

		if (s1.length() != s2.length())
			return false;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++)
			hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);

		for (int i = 0; i < s2.length(); i++) {

			if (hm.containsKey(s2.charAt(i))) {
				hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
				if (hm.get(s2.charAt(i)) == 0)
					hm.remove(s2.charAt(i));
			} else
				k--;

			if (k < 0)
				return false;
		}

		return true;
	} // TC : O(n), SC : O(n)

	public static boolean checkIfKAnagram_Opt(String s1, String s2, int k) {

		if (s1.length() != s2.length())
			return false;

		int[] freq = new int[26];// O(1)

		for (int i = 0; i < s1.length(); i++)
			freq[s1.charAt(i) - 'a']++;

		for (int i = 0; i < s2.length(); i++)
			freq[s2.charAt(i) - 'a']--;

		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0)// when chars differ, they differ by same length for both s1 and s2. So
							// either checking freq for > 0 (or < 0) should provide same result
				cnt += freq[i];
		}

		return cnt <= k;

	} // TC : O(2n), SC : O(1)

	public static void main(String[] args) {

		String s1 = "ukdbgygrsjlaukwsgc";
		String s2 = "memdwhetaewfahkc";
		int k = 14;

//		String s1 = "geeks";
//		String s2 = "eggkf";
//		int k = 2;

		System.out.println(checkIfKAnagram(s1, s2, k));
		System.out.println(checkIfKAnagram_(s1, s2, k));
		System.out.println(checkIfKAnagram_Opt(s1, s2, k));

	}
}