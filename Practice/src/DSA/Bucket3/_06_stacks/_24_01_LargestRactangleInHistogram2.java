package DSA.Bucket3._06_stacks;

import java.util.Arrays;
import java.util.Stack;

public class _24_01_LargestRactangleInHistogram2 {

	public static int[] findPrevSmallerEle(int[] arr) {

		Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
		int[] pse = new int[arr.length]; // SC: O(N)

		for (int i = 0; i < arr.length; i++) { // O(N)

			while (!st.isEmpty() && arr[i] <= arr[st.peek()]) // O(N)
				st.pop();

			if (st.isEmpty())
				pse[i] = i - (-1);
			else
				pse[i] = i - st.peek();

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

			if (st.isEmpty())
				nse[i] = arr.length - i - 1;
			else
				nse[i] = st.peek() - i - 1;

			st.push(i);
		}

		return nse; // Total TC : O(2N)
	}

	public static int findLongestRectangleArea(int[] arr) {

		int[] pse = findPrevSmallerEle(arr); // TC: O(2N), SC: O(2N)
		int[] nse = findNxtSmallerEle(arr); // TC: O(2N), SC: O(2N)

		int maxArea = 0;
		int[] area = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
			area[i] = arr[i] * (pse[i] + nse[i]);

		System.out.println(Arrays.toString(area));

		for (int i : area)
			maxArea = Math.max(maxArea, i);

		return maxArea; // Total TC : O(5N), SC : O(4N)

	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(findLongestRectangleArea(arr));
	}

}
