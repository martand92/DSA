package DSA.Bucket2._06_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/count-the-characters1821/1
public class _16_CountCharacters_O_S {

	public static void main(String[] args) {

		String S = "geeksforgeeks";
		int N = 2;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int count = 0;

		for (int i = 0; i < S.length(); i++) {

			if (i == 0)
				hm.put(S.charAt(i), 1);

			else if (S.charAt(i) != S.charAt(i - 1))
				hm.put(S.charAt(i), hm.getOrDefault(S.charAt(i), 0) + 1);
		}

		for (Map.Entry<Character, Integer> e : hm.entrySet()) {
			if (e.getValue() == N)
				count++;
		}

		System.out.println(count);

	}

}
