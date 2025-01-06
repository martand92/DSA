package DSA._02_strings;

import java.util.*;

//
public class _06_ShortestDistance {
	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<String>();
		s.add("jd");
		s.add("lzt");
		s.add("kym");
		s.add("ky");
		s.add("gdf");
		s.add("gdf");
		s.add("jd");

		String word1 = "kym", word2 = "gdf";

		int word1Index = -1, word2Index = -1, diff = Integer.MAX_VALUE;
		for (int i = 0; i < s.size(); i++) {

			if (s.get(i).equals(word1))
				word1Index = i;

			if (s.get(i).equals(word2))
				word2Index = i;

			if (word1Index != -1 & word2Index != -1)
				diff = Math.min(diff, Math.abs(word2Index - word1Index));
		}

		System.out.println(diff);

	}
	
}