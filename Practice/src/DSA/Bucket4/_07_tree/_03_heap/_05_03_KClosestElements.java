package DSA.Bucket4._07_tree._03_heap;

import java.util.*;

//https://www.youtube.com/watch?v=Of4bdCDwcdY
//https://leetcode.com/problems/find-k-closest-elements/description/
public class _05_03_KClosestElements {

	public static class Pair {
		int value;
		int diff;

		Pair(int value, int diff) {
			this.value = value;
			this.diff = diff;
		}
	}

	public static int[] findKClosestElements(int[] arr, int k, int x) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : arr)
			hm.put(i, Math.abs(i - x));

		// create max heap of difference and then value so that max differed element
		// with higher value will be root which shouldn't be considered
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				if ((b.diff - a.diff) != 0)
					return b.diff - a.diff; // first create max heap of difference as maximum difference should not be
											// considered
				else // if multiple elements has same max diff, then have max value as root as it
						// shouldn't be considered
					return b.value - a.value;
			}
		});

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			pq.add(new Pair(e.getKey(), e.getValue()));
			if (pq.size() > k)
				pq.remove();
		}

		int[] finalArr = new int[k];
		int i = 0;
		for (Pair p : pq) {
			finalArr[i] = p.value;
			i++;
		}

		Arrays.sort(finalArr);
		return finalArr;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4, x = 3;
		System.out.println(Arrays.toString(findKClosestElements(arr, k, x)));
	}

}
