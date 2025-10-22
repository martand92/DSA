package DSA.Bucket3._02_strings;

import java.util.*;

public class _06_ShortestDistance {

	public static int findShortestDist(ArrayList<String> list, String word1, String word2) {

		int idx1 = -1, idx2 = -1, minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) == word1)
				idx1 = i;

			if (list.get(i) == word2)
				idx2 = i;

			if (idx1 != -1 && idx2 != -1)
				minDiff = Math.min(minDiff, Math.abs(idx1 - idx2));
		}

		return minDiff;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(List.of("jd", "lzt", "kym", "ky", "gdf", "gdf", "jd"));
		System.out.println(findShortestDist(list, "kym", "gdf"));
	}
}
//TC : O(S)