package DSA.Bucket2._06_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1
public class _06_NonRepeatingChar {

	public static void main(String[] args) {

		String s = "hellho";
		char nonRepeatingFirstChar = 0;

		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);

		for (Map.Entry<Character, Integer> e : hm.entrySet()) {

			if (e.getValue() == 1) {
				nonRepeatingFirstChar = e.getKey();
				break;
			}
		}

		System.out.println(nonRepeatingFirstChar);

	}

}
