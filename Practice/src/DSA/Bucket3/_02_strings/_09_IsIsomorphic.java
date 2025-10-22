package DSA.Bucket3._02_strings;

import java.util.*;

public class _09_IsIsomorphic {

	public static boolean isIsomorphic(String str1, String str2) {

		// Convert to digits from 0 .. n and compare final formed digits
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();

		if (str1.length() != str2.length())
			return false;

		for (int i = 0; i < str1.length(); i++) {
			hm1.putIfAbsent(str1.charAt(i), i);// Consecutive mapping not needed
			hm2.putIfAbsent(str2.charAt(i), i);

			if (!hm1.get(str1.charAt(i)).equals(hm2.get(str2.charAt(i))))
				return false;
		}

		return true;

	}// O(S)

	public static void main(String[] args) {
		String str1 = "aabba";
		String str2 = "xxyyx";

		System.out.println(isIsomorphic(str1, str2));
	}
}