package DSA._06_stacks;

import java.util.*;

// https://www.youtube.com/watch?v=7PrncD7v9YQ
// Need to find NGE of given element on both right side and then on left side imagining that array is circular
// i.e, from i+1 -> n and then from 0 -> i-1

// Intuition : As we need to find first on right and then on left side for NGE, need to imagine doubling array so that for last element of array NGE can be found
// Ex: if arr = {2, 10, 12, 1, 11}, then hypothetically double arr = {2, 10, 12, 1, 11, 2, 10, 12, 1, 11}
// Now for arr[4], expected NGE as 12 which is on hypothetical index=7 or real index 7 % 5 = 2 (hypothetical index % N)

public class _18_02_NGE_MonotonicStack_CircularArr {

	public static int[] nextGreaterElement(int[] arr) {

		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();

		// Instead of running loop from n-1 -> 0 , run it from 2n-1 -> 0 such that
		// anything above n-1 is hypothetical and lies of left side
		// and to find real index of hypothetical index use curr_index(i) % n
		int n = arr.length;

		for (int i = (2 * n) - 1; i >= 0; i--) { // need to loop till double array end where 2nd array is hypothetical

			while (!st.isEmpty() && arr[i % n] >= st.peek()) // need to make sure if curr index > real arr length then
																// we need to circle back index to real arr index by
																// taking %N
				st.pop();

			if (i < n) {
				if (st.empty())
					nge[i] = -1;
				else
					nge[i] = st.peek();
			}

			st.push(arr[i % n]);
		}

		return nge;

	}

	public static void main(String[] args) {

		int[] arr = { 2, 10, 12, 1, 11 };// for 2 NGE is 10, 10 NGE is 12, 12 NGE is not available on right side / left
											// side so -1, 1 NGE is 11, 11 NGE on right side is not available so check
											// on left you find 12
		System.out.println(Arrays.toString(nextGreaterElement(arr)));
	}

}

//TC : O(2N) and not O(N^2) cz inner while() runs for max n elements and not for every outer arr ele
//SC : O(N) for stack + O(N) for nge[]