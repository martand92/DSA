package DSA.Bucket2._03_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1
public class _07_IntersectionOfTwoArrays {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6 };

		int[] b = { 3, 4, 5, 6, 7 };

		int count = 0;

		// approach 1 : Using HashSet
		LinkedHashSet<Integer> hs1 = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> hs2 = new LinkedHashSet<Integer>();

		for (int i = 0; i < a.length; i++)
			hs1.add(a[i]);// first removing duplicates within array

		for (int j = 0; j < b.length; j++)
			hs2.add(b[j]);

		for (int i : hs2) {
			if (hs1.contains(i))// loop second array(without duplicates) to check for intersecting elements
				count++;
		}

		System.out.println("Using HashSet : " + count);

		// approach 2 : Using HashMap
		count = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (hm.get(a[i]) == null)
				hm.put(a[i], 1);
		}

		for (int i = 0; i < b.length; i++) {
			if (hm.get(b[i]) != null)
				hm.put(b[i], hm.get(b[i]) + 1);

		}

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			if (e.getValue() > 1)
				count++;
		}

		System.out.println("Using HashMap : " + count);

	}

}
