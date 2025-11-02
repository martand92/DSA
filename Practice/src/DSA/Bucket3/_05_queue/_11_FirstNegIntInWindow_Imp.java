package DSA.Bucket3._05_queue;

import java.util.*;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class _11_FirstNegIntInWindow_Imp {

	public static ArrayList<Integer> firstNegIntegers(int[] arr, int k) {

		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		int l = 0;

		for (int r = 0; r < arr.length; r++) {

			if (arr[r] < 0)
				q.add(arr[r]);

			if ((r - l + 1) > k) {

				if (!q.isEmpty() && arr[l] == q.peek())
					q.poll();

				l++;
			}

			if ((r - l + 1) == k) {
				if (!q.isEmpty())
					al.add(q.peek());
				else
					al.add(0);
			}
		}

		return al;
	}

	public static void main(String[] args) {

		int[] arr = { -8, 2, 3, -6, 10 };
		int k = 2;

		System.out.println(firstNegIntegers(arr, k));
	}
}

//TC : O(n), SC : O(2n)
