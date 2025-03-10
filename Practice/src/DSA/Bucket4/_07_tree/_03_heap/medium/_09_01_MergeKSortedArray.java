package DSA.Bucket4._07_tree._03_heap.medium;

import java.util.*;

//below solution works if provided arr is matrix of dimension k*k
public class _09_01_MergeKSortedArray {

	private static ArrayList<Integer> mergeKSortedArray(int[][] arr) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();// min heap

		// k=no of rows and n=no of col
		for (int k = 0; k < arr.length; k++) {
			for (int n = 0; n < arr[0].length; n++) // k*n 
				pq.add(arr[k][n]); // log(n) sorting is done on number of elements in each row
		}

		ArrayList<Integer> al = new ArrayList<Integer>();
		while (!pq.isEmpty()) { //k*n
			al.add(pq.poll());
		}

		return al;
	}

	public static void main(String[] args) {
		int[][] arr = { { 2, 6, 12 }, { 1, 9, 10 }, { 23, 34, 90 } };
		System.out.println(mergeKSortedArray(arr));
	}

}

//TC : k*n*log(n) + k*n = knlog(n)
//SC : O(k*K) // need pq and al to accommodate all k*k elements 