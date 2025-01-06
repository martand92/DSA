package DSA._06_stacks;

import java.util.*;

// https://www.youtube.com/watch?v=zMdbdGJNlh4
// Need to find prev smaller element on left side of current element
public class _19_01_PSE_MonotonicStack {

	public static int[] prevSmallerElement(int[] arr) {

		int[] pse = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();// Monotonically decreasing stack

		for (int i = 0; i < arr.length; i++) {

			if (st.isEmpty()) {
				pse[i] = -1;
				st.push(arr[i]);

			} else if (arr[i] > st.peek()) {
				pse[i] = st.peek();
				st.push(arr[i]);

			} else {

				while (!st.isEmpty() && arr[i] <= st.peek())
					st.pop();

				if (!st.isEmpty())
					pse[i] = st.peek();
				else
					pse[i] = -1;

				st.push(arr[i]);
			}

		}

		return pse;

	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 10, 8 };
		System.out.println(Arrays.toString(prevSmallerElement(arr)));
	}

}

//TC : O(2N)
//SC : O(N) for stack + O(N) for pse[]