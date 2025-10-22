package DSA.Bucket3._02_strings;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/pangram-checking-1587115620/1
public class _10_IsPanagram {

	public static boolean isPanagram(String str) {

		str = str.toLowerCase();
		HashSet<Character> hs = new HashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - 'a' >= 0 && str.charAt(i) - 'a' < 26)
				hs.add(str.charAt(i));
		}

		return hs.size() == 26;
	}

	public static void main(String[] args) {
		String str = "Bbawds jog, flick quartz, vex nymphh9";
		System.out.println(isPanagram(str.toLowerCase()));
	}
}