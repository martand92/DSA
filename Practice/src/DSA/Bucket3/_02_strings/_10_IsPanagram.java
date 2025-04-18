package DSA.Bucket3._02_strings;

import java.util.*;


//https://practice.geeksforgeeks.org/problems/pangram-checking-1587115620/1
public class _10_IsPanagram {
	public static void main(String[] args) {

		String str = "Bbawds jog, flick quartz, vex nymphh9";
		str = str.toLowerCase();
		str = str.replaceAll("[^a-zA-Z]", "");

		System.out.println(str);

		char[] a = str.toCharArray();
		HashSet<Character> hs = new HashSet<Character>();

		for (int i = 0; i < a.length; i++) {
			hs.add(a[i]);
		}

		System.out.println(hs.size());

	}
}
