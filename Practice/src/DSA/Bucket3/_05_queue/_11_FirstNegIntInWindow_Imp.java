package DSA.Bucket3._05_queue;

import java.util.*;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class _11_FirstNegIntInWindow_Imp {

	public static void main(String[] args) {
		int[] arr = { -8, 2, 3, -6, 10 };
		int k = 2;

		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int j = 0;

		// Add neg elements to Q from current window
		for (int i = 0; i < k; i++) {
			if (arr[i] < 0)
				q.add(arr[i]);

		}

		// Slide window by 1
		for (int i = k; i <= arr.length; i++) {

			// If q contains neg element then add to resultant array list else add zero
			if (q.size() > 0)
				al.add(q.peek());
			else
				al.add(0);

			// remove neg element from q from window only if thats the first element in that
			// window as window slides
			if (q.peek() != null) {
				if (arr[j] == q.peek())
					q.poll();
			}

			j++;

			// add next element to queue if its negative
			if (i != arr.length && arr[i] < 0)
				q.add(arr[i]);
		}

		System.out.println(al);
	}

}
