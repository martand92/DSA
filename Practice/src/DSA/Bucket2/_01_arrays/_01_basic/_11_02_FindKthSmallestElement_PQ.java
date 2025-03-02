package DSA.Bucket2._01_arrays._01_basic;

import java.util.PriorityQueue;
import java.util.Queue;

// If a[] = 7 10 4 20 15, then return 4th smallest element i.e 15
public class _11_02_FindKthSmallestElement_PQ {
	public static void main(String[] args) {
		int[] a = { 7, 10, 4, 20, 15 };
		int k = 4;

		Queue<Integer> pq = new PriorityQueue<Integer>(); // SC: O(N)

		for (int i = 0; i < a.length; i++) // O(N)
			pq.add(a[i]);

		for (int i = 0; i < k - 1; i++) // O(K)
			pq.remove();

		System.out.println(pq.remove());
	}
}
//TC : O(N + K)
//SC : O(N)
