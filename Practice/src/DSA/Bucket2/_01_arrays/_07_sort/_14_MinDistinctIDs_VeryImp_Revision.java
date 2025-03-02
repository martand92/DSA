package DSA.Bucket2._01_arrays._07_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/minimum-distinct-ids3251/1
public class _14_MinDistinctIDs_VeryImp_Revision {

	public static void main(String[] args) {

		int arr[] = { 2, 2, 1, 3, 3, 3 };
		int m = 3;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		//
		//
		//
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}

		});

		//
		//
		//
		// Above sorted list to be copied to another temp arr in order : LinkedHashMap
		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();

		for (Map.Entry<Integer, Integer> aa : list)
			temp.put(aa.getKey(), aa.getValue());

		// Use Iterator to iterate over and parallely remove entry
		Iterator<Map.Entry<Integer, Integer>> iterator = temp.entrySet().iterator();

		while (iterator.hasNext()) {

			Map.Entry<Integer, Integer> e = iterator.next();

			m = m - e.getValue();

			if (m >= 0)
				iterator.remove();

			else
				break;
		}

		System.out.println(temp.size());

	}
}
