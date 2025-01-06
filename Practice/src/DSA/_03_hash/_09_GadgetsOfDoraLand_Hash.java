package DSA._03_hash;

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

		for (int i = 0; i < a.length; i++) {

			if (hm.containsKey(a[i]))
				hm.put(a[i], hm.get(a[i]) + 1);

			else
				hm.put(a[i], 1);
		}

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

				// Sort by values, if values are same then sort by keys
				int cmp1 = o2.getValue().compareTo(o1.getValue());

				if (cmp1 != 0)
					return cmp1;

				else
					return o2.getKey().compareTo(o1.getKey());
			}

		});

		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();

		for (Map.Entry<Integer, Integer> aa : list)
			temp.put(aa.getKey(), aa.getValue());

		for (Map.Entry<Integer, Integer> e : temp.entrySet()) {
			if (k == 0)
				break;

			al.add(e.getKey());
			k--;
		}

		System.out.println(al);

	}
}
