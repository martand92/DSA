package DSA.Bucket2._05_slidingWindow;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/d6e88f06b273a60ae83992314ac514f71841a27d/1
public class _06_SmallestWindowContaining012_Imp {

	public static void main(String[] args) {

		// String s = "112220100000000000000";
		String s = "12121";

		int smallestWindow = Integer.MAX_VALUE, l = 0;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int r = 0; r < s.length(); r++) {

			hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);

			while (hm.size() == 3) {

				smallestWindow = Math.min(smallestWindow, (r - l + 1));

				int val = hm.get(s.charAt(l));

				if (val > 1)
					hm.put(s.charAt(l), val - 1);
				else
					hm.remove(s.charAt(l));

				l++;

			}
		}

		System.out.println(smallestWindow == Integer.MAX_VALUE ? -1 : smallestWindow);

	}
}
