package DSA.Bucket3._05_queue;

import java.util.*;

public class _01_PriorityQueueInDescendingOrder {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, // size of Q
//				new Comparator<Integer>() {
//					public int compare(Integer a, Integer b) {
//						return b - a;
//					}
//				}
//		);

		pq.add(1);
		pq.add(2);
		pq.add(3);
		pq.add(4);
		pq.add(5);

		while (!pq.isEmpty())
			System.out.println(pq.poll());
	}

}
