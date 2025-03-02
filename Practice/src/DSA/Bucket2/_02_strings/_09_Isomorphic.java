package DSA.Bucket2._02_strings;

import java.util.*;

public class _09_Isomorphic {

	public static void main(String[] args) {
		String str1 = "aabba";
		String str2 = "xxyyx";

		//Convert to digits from 0 .. n and compare final formed digits
		String str1Pattern = getPattern(str1).toString();
		String str2Pattern = getPattern(str2).toString();

		if (str1Pattern.equals(str2Pattern))
			System.out.println("Isomorphic");
		else
			System.out.println("Not Isomorphic");



	}

	public static StringBuilder getPattern(String str) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int count = 0;
		StringBuilder strn = new StringBuilder(); 

		for (int i = 0; i < str.length(); i++) {

			if (!hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), count);
				count++;
			}
		}
		
		for(int i = 0; i < str.length(); i++)
			strn.append(hm.get(str.charAt(i)));
		
		return strn;
			
	}

}
