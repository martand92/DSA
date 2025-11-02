package DSA.Bucket3._06_stacks;

import java.util.*;

//https://www.youtube.com/watch?v=e7XQLtOQM3I
//Need to find next greater element on right side of current element
public class _20_01_NGE_Imp {

	public static int[] nextGreaterElement(int[] arr) {

		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();// Monotonically increasing stack

		for (int i = arr.length - 1; i >= 0; i--) {

			if (st.isEmpty()) {
				nge[i] = -1;
				st.push(arr[i]);

			} else if (arr[i] < st.peek()) {
				nge[i] = st.peek();
				st.push(arr[i]);

			} else { // arr[i] > st.peek() meaning current element is looking for NGE which is not st
						// peek, so need to pop out st till its greater than current

				while (!st.isEmpty() && arr[i] >= st.peek()) // pop out till stack is empty or st peek > curr element
					st.pop();

				if (!st.isEmpty())
					nge[i] = st.peek();
				else
					nge[i] = -1;
				st.push(arr[i]);
			}

		}

// Above code can also be optimally written as
//		int n = arr.length;
//		for (int i = n - 1; i >= 0; i--) {
//
//			while (!st.isEmpty() && arr[i] >= st.peek())
//				st.pop();
//			
//			if (st.empty())
//				nge[i] = -1;
//			else
//				nge[i] = st.peek();
//			
//			st.push(arr[i]);
//		}

		return nge;

	}

	public static void main(String[] args) {
		// int[] arr = { 6, 0, 8, 1, 3 };// for 6 NGE is 8, 0 NGE is 8, 8 NGE is -1 (as
		// there is no greater element on right side)

		int[] arr = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
		System.out.println(Arrays.toString(nextGreaterElement(arr)));
	}

}

//TC : O(2N) and not O(N^2) cz inner while() runs for max n elements and not for every outer arr ele
//SC : O(N) for stack + O(N) for nge[]