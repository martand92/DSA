package DSA._07_tree._03_heap;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/adding-array-element4756/1
public class _06_AddingArrayElements {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 12, 9, 2, 3 };
		int k = 6;
		Queue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);

		System.out.println(minOperations(pq, k, 0));

	}

	private static int minOperations(Queue<Integer> pq, int k, int count) {
		// TODO Auto-generated method stub
		if (pq.size() == 1) {

			if (pq.peek() >= k)
				return count;
			else
				return -1;
		}

		else if (pq.peek() >= k)
			return count;

		else {
			pq.add(pq.remove() + pq.remove());
			count++;
			return minOperations(pq, k, count);
		}

	}
}
