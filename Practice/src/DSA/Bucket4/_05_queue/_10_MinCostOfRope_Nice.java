package DSA.Bucket4._05_queue;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class _10_MinCostOfRope_Nice {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 6 };
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int sum = 0, a = 0, b = 0;

		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);

		while (pq.size() > 1) {
			a = pq.poll();
			b = pq.poll();
			sum += a + b;
			pq.add(a + b);
		}

		System.out.println(sum);

	}

}
