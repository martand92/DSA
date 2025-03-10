package DSA.Bucket4._07_tree._03_heap;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/maximum-distinct-elements-after-removing-k-elements5906/1
public class _08_MaxDistinctEleAfterRemovingKEle {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 5;

//		int[] a = {5, 7, 5, 5, 1, 2, 2};
//		int k = 3;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++)
			hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);

		// Add values of hm specifying frequency to pq in descending order

		// Priority queue prioritize in descending order = Max heap
		// If Priority Queue is in normal order = Min heap
		Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.addAll(hm.values());

		// Now, perform the following operation k times. Remove an element from the max
		// heap. Decrement its value by 1. After this, if element is not equal to 0,
		// then again push the element in the max heap
		while (k > 0 && pq.size() > 0) {

			if (pq.peek() > 1) {
				pq.add(pq.poll() - 1);

			} else if (pq.peek() == 1)// if pq peek ele = 1, meaning all elements are now 1 in pq
				pq.remove();

			k--;
		}

		// once all required values are removed, remaining q size is the ans
		System.out.println(pq.size());

	}
}
