package DSA._07_tree._03_heap.medium;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1

//similar question exists in hash -> Gadgets of dora land
public class _12_TopKFrequentElementsInArr_Imp {

	public static void main(String[] args) {
//		int[] nums = { 1, 1, 1, 2, 2, 3 };
//		int k = 2;

		int[] nums = { 1, 1, 2, 2, 3, 3, 3, 4 };
		int k = 2;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

//		 1st Method : Using HashMap. Sorting above hashMap by values in descending order and then sort by key in
//		 descending order
//		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
//
//		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//				int cmp1 = o2.getValue().compareTo(o1.getValue());
//				if (cmp1 != 0)
//					return cmp1;
//				else
//					return o2.getKey().compareTo(o1.getKey());
//			}
//		});
//
//		for (int i = 0; i < k; i++)
//			System.out.println(list.get(i).getKey());

		// 2nd Method : Using Priority Queue
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(

				new Comparator<Map.Entry<Integer, Integer>>() {

					public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {

						if (a.getValue() == b.getValue())
							return b.getKey() - a.getKey();
						else
							return b.getValue() - a.getValue();
					}
				});

		for (Map.Entry<Integer, Integer> e : hm.entrySet())
			pq.add(e);

		for (int i = 0; i < k; i++)
			System.out.println(pq.remove().getKey());

	}
}
