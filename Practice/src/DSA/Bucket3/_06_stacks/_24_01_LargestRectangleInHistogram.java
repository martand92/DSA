package DSA.Bucket3._06_stacks;

import java.util.Stack;

public class _24_01_LargestRectangleInHistogram {

	public static int[] findPrevSmallerEleIndex(int[] arr) {

		Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
		int[] psei = new int[arr.length]; // SC: O(N)

		for (int i = 0; i < arr.length; i++) { // O(N)

			while (!st.isEmpty() && arr[i] <= arr[st.peek()]) // O(N)
				st.pop();

			if (st.isEmpty()) // if no pse is found for given arr[i] then have pse as -1
				psei[i] = -1;
			else
				psei[i] = st.peek();

			st.push(i);
		}

		return psei; // Total TC : O(2N)
	}

	public static int[] findNxtSmallerEleIndex(int[] arr) {

		Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
		int[] nse = new int[arr.length]; // SC: O(N)

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && arr[i] <= arr[st.peek()])
				st.pop();

			if (st.isEmpty())// if no nse is found for given arr[i] then have nse as n
				nse[i] = arr.length;
			else
				nse[i] = st.peek();

			st.push(i);
		}

		return nse; // Total TC : O(2N)
	}

	public static int findLongestRectangleArea(int[] arr) {

		int[] pse = findPrevSmallerEleIndex(arr); // TC: O(2N), SC: O(2N)
		int[] nse = findNxtSmallerEleIndex(arr); // TC: O(2N), SC: O(2N)

		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) // TC : O(N)
			// from nse to pse calculate area for current indexed rectangle
			maxArea = Math.max(maxArea, arr[i] * (nse[i] - pse[i] - 1));

		return maxArea; // Total TC : O(5N), SC : O(4N)
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(findLongestRectangleArea(arr));
	}

}
