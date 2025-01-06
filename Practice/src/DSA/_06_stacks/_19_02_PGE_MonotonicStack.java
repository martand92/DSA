package DSA._06_stacks;

import java.util.*;

// https://www.geeksforgeeks.org/previous-greater-element/
// Need to find prev greater element on left side of current element
public class _19_02_PGE_MonotonicStack {

	public static int[] prevGreaterElement(int[] arr) {

		int[] pge = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();
		// int n = arr.length;

		for (int i = 0; i < arr.length; i++) {

			while (!st.isEmpty() && arr[i] >= st.peek())
				st.pop();

			if (st.empty())
				pge[i] = -1;
			else
				pge[i] = st.peek();

			st.push(arr[i]);
		}

		return pge;

	}

	public static void main(String[] args) {
		int[] arr = { 10, 4, 2, 20, 40 };
		System.out.println(Arrays.toString(prevGreaterElement(arr)));
	}

}

//TC : O(2N)
//SC : O(N) for stack + O(N) for pge[]