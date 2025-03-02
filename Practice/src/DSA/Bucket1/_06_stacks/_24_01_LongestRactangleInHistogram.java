package DSA.Bucket1._06_stacks;

import java.util.Arrays;
import java.util.Stack;

public class _24_01_LongestRactangleInHistogram {

	public static int[] findPrevSmallerEle(int[] arr) {

		Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
		int[] pse = new int[arr.length]; // SC: O(N)

		for (int i = 0; i < arr.length; i++) { // O(N)

			while (!st.isEmpty() && arr[i] <= arr[st.peek()]) // O(N)
				st.pop();

			if (st.isEmpty()) // if no pse is found for given arr[i] then have pse as -1
				pse[i] = -1;
			else
				pse[i] = st.peek();

			st.push(i);
		}

		return pse; // Total TC : O(2N)
	}

	public static int[] findNxtSmallerEle(int[] arr) {

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

		int[] pse = findPrevSmallerEle(arr); // TC: O(2N), SC: O(2N)
		int[] nse = findNxtSmallerEle(arr); // TC: O(2N), SC: O(2N)
		int[] arearec = new int[arr.length];
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) { // TC : O(N)
			arearec[i] = arr[i] * (nse[i] - pse[i] - 1);
			int area = arr[i] * (nse[i] - pse[i] - 1); // from nse to pse calculate area for current indexed rectangle
			maxArea = Math.max(maxArea, area);
		}
		System.out.println(Arrays.toString(arearec));
		return maxArea; // Total TC : O(5N), SC : O(4N)

	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(findLongestRectangleArea(arr));
	}

}
