package DSA.Bucket2._06_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/bbd15e2da95880979ce65acc7360e2c5681664e65520/1
public class _09_GadgetsOfDoraLand_Hash {

	public static void main(String[] args) {
//		int[] a = { 1, 1, 2, 2, 3, 3, 3, 4 };
//		int k = 2;
		// int initk = k;

//		int[] a = { 1, 1, 1, 2, 2, 3 };
//		int k = 2;

		int[] a = { 5, 4, 2 };
		int k = 3;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++)
			hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o2.getValue() != o1.getValue())
					return o2.getValue() - o1.getValue();
				else
					return o2.getKey() - o1.getKey();
			}
		});

		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();

		for (Map.Entry<Integer, Integer> e : list)
			temp.put(e.getKey(), e.getValue());

		for (Map.Entry<Integer, Integer> e : temp.entrySet()) {
			if (k == 0)
				break;

			al.add(e.getKey());
			k--;
		}

		System.out.println(al);

	}
}
