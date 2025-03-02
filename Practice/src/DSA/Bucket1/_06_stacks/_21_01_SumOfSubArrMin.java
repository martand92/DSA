package DSA.Bucket1._06_stacks;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/description/
//Need to find sum of all minimum numbers from all possible sub arrays

public class _21_01_SumOfSubArrMin {

	public static int minElementInSubArrSum_BruteForce(int[] arr) {

		int sum = 0;
		int mod = (int) 1e9 + 7;
		for (int i = 0; i < arr.length; i++) {

			int min = Integer.MAX_VALUE;

			for (int j = i; j < arr.length; j++) { // sub array is from i to j
				min = Math.min(min, arr[j]);
				sum += min % mod;
			}

		}

		return sum;
		// TC: O(N^2), SC: O(1)
	}

	// TC : O(N), SC : O(N)
	public static int minElementInSubArrSum_Stack(int[] arr) {

		// find pse and nse for given element
		// no of elements on left and right form left length * right length no of
		// subarrays
		// Contribution of current element to above sub arrays for total = curr element
		// * no of sub arrays

		int total = 0;
		int[] pse = findPrevSmallerEqualElement(arr); // SC : O(N)
		int[] nse = findNxtSmallerElement(arr); // SC : O(N)

		for (int i = 0; i < arr.length; i++) { // TC : O(N)
			int left = i - pse[i];
			int right = nse[i] - i;
			total += (left * right) * arr[i];
		}

		return total;

		// SC : O(2N)
		// TC : O(N)
	}

	private static int[] findPrevSmallerEqualElement(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();
		int[] pse = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			// Below for pse of given arr[i] check only for greater element to be popped out
			// Not just smaller but also equal elements will be considered cz of below edge
			// case :

			// Edge case : when adjacent elements in array are duplicates . Ex: {3,1,1,4}
			// Now for 1st occurence of 1 at index 1,
			// nse is none so nse[i]=arr.length=4, pse is none so pse[i]=-1. so
			// left:1-(-1)=2, right:4-1=3
			// so total consideration : 2 * 3 * 1 = 6 times 1 occurs as min
			// left : {3,1} {1}
			// right : {1,1,4} {1,1} {1,4}
			// Now for 2nd 1, you should consider previous 1 which is equal as well and not
			// just previous small
			// Hence need to pop out only if previous added element to stack is greater and
			// not if its equal -> didn't understand

			while (!st.isEmpty() && arr[st.peek()] > arr[i]) // as st.peek() contains index of the previous element
				st.pop();

			if (st.isEmpty())
				pse[i] = -1; // if no pse is found for current element then store pse as -1
			else
				pse[i] = st.peek(); // since need to have pse's index value and not the actual element as further
									// calculations are based on indices only

			st.push(i); // need to store index cz in prev step pse[i] is assigned with stack's peek as
						// we are dealing with index
		}

		return pse;

	}

	private static int[] findNxtSmallerElement(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();
		int[] nse = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && arr[st.peek()] >= arr[i])
				st.pop();

			if (st.isEmpty())
				nse[i] = arr.length;// if no nse is found for given arr[i] then have nse as n
			else
				nse[i] = st.peek();

			st.push(i);
		}

		return nse;
	}

	public static void main(String[] args) {
		// int[] arr = { 3, 1, 1, 4 }; //data with duplicates need to be explicitly
		// handled. Edge case
		int[] arr = { 3, 1, 2, 4 };
		System.out.println("Min Sum using Brute Force : " + minElementInSubArrSum_BruteForce(arr));
		System.out.println("Min Sum using Monotonic Stack : " + minElementInSubArrSum_Stack(arr));
	}
}
