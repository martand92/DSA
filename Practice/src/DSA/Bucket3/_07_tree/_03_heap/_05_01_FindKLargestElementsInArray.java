package DSA.Bucket3._07_tree._03_heap;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
// Space : O(K) 
// Time : O(N log K)
public class _05_01_FindKLargestElementsInArray {

	public static void main(String[] args) {
		int[] arr = { 12, 5, 787, 1, 23 };
		int k = 2;
		Queue<Integer> pq = new PriorityQueue<Integer>(); // min heap

		for (int i = 0; i < arr.length; i++) { // keep adding elements to min heap of size k so that whenever size
												// exceeds k then top(least) element is popped and at last k largest
												// elements will remain

			pq.add(arr[i]);

			if (pq.size() > k)
				pq.remove();
		}

		System.out.println(pq);

		// if question is to print kth largest element and not k largest elements, then
		// print root of pq

	}
}
