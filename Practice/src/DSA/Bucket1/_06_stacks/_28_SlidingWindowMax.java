package DSA.Bucket1._06_stacks;

import java.util.*;

// Algo :
// you need to provide max element in a given window in O(N) TC,
// you should be able to push your element into datastructure and pop last/bottom element if 
//	* its lesser than current(as current will be your max) or
//  * element goes out of window 
// This lets data structure to maintain monotonically decreasing elements so that for a given window last bottom element represents current window's max (though its monotonically decreasing)
// So to push from top and to pop from bottom, you can use data structure Deque

//Need to store only indices and not actual elements in Deque cz when window size match k, you need to remove element from deque front if it falls outside window

//Hence this problem is of monotonic queue
public class _28_SlidingWindowMax {

	public static ArrayList<Integer> findMaxElementsInGivenWindow(int[] num, int k) {

		int l = 0, r = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

		while (r <= num.length) {

			if (r - l == k) {
				result.add(num[deque.peekFirst()]);

				if (l == deque.peekFirst())// element at lth index is falling out of current window and as deque has
											// same index, it goes out of scope. Hence removing from deque
					deque.pollFirst();

				l++;
			}

			while (r < num.length && !deque.isEmpty() && num[r] >= num[deque.peek()]) // if current element > previous
																						// which is added to
				// deque then pop as looking for max and need to
				// maintain monotonic decreasing queue
				deque.pollFirst();

			deque.addLast(r); // adding index and not element as while popping out need to check if this
								// element is going out of window
			r++;
		}

		return result;
	}

	public static void main(String[] args) {
//		int[] num = { 1, 3, -1, -3, 5, 3, 6, 7 };
//		int k = 3;

		int[] num = { 1 };
		int k = 1;

		System.out.println(findMaxElementsInGivenWindow(num, k));
	}

}
