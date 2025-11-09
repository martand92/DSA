package DSA.Bucket4._06_stacks;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/description/
//Need to find sum of all minimum numbers from all possible sub arrays

public class _23_01_SumOfSubArrOfMinimums {

	public static int sumOfMinEleInSubArr_BruteForce(int[] arr) {

		int sum = 0;
		int mod = (int) 1e9 + 7;

		for (int i = 0; i < arr.length; i++) {

			int min = Integer.MAX_VALUE;

			for (int j = i; j < arr.length; j++) { // sub array is from i to j
				min = Math.min(min, arr[j]);
				sum += min % mod;
			}
		}

		return sum; // TC: O(N^2), SC: O(1)
	}

	// TC : O(N), SC : O(N)
	public static int sumOfMinEleInSubArr_Stack(int[] arr) {

		/*
		 * For each arr[i], how many subarrays have arr[i] as their minimum
		 * 
		 * Two directions matter:
		 * 
		 * How far left can we extend the subarray before hitting something smaller or
		 * equal than arr[i] : PSEE. If no psi, then return -1
		 * 
		 * How far right can we extend the subarray before hitting something smaller
		 * than arr[i] : NSE. If no nsi then return arr.length
		 * 
		 * SubArrays where arr[i] is min = (i-psi[i]) * (nsi[i] * i)
		 * 
		 * arr[i] contributing to totalSum = (SubArrays where arr[i] is min)*(arr[i])
		 * 
		 */

		int sum = 0;
		int[] psei = findPrevSmallerEqualElementIndex(arr); // SC : O(N)
		int[] nsei = findNxtSmallerElementIndex(arr); // SC : O(N)

		for (int i = 0; i < arr.length; i++) { // TC : O(N)
			int left = i - psei[i];
			int right = nsei[i] - i;
			sum += (left * right) * arr[i];
		}

		return sum;

		// SC : O(2N)
		// TC : O(N)
	}

	// same as pse except we are storing index of pse instead of element
	private static int[] findPrevSmallerEqualElementIndex(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();
		int[] psei = new int[arr.length];

		// leftward check
		for (int i = 0; i < arr.length; i++) {

			// For given subarray : {3,1,1,4}, If there are adjacent duplicates then filter
			// duplicate subarrays

			// subarrays containing arr[1]=1 as min : {1}, {3,1}, {1,1}, {1,1,4}
			// subarrays containing arr[2]=1 as min: {1}, {1,1}, {1,1,3}, {1,4}

			// as {1} and {1,1} are repeated in both results, ensure each subarray is
			// counted exactly once,
			// Hence final subarrays are : {1}, {3,1}, {1,1}, {1,1,4}, {1,1,3}, {1,4} = 6

			// allows equal elements to stay in the stack
			while (!st.isEmpty() && arr[st.peek()] > arr[i])
				st.pop();

			if (st.isEmpty())
				psei[i] = -1;
			else // if(!st.isEmpty() && arr[st.peek()] < arr[i])
				psei[i] = st.peek();

			st.push(i);
		}

		return psei;

	}

	private static int[] findNxtSmallerElementIndex(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();
		int[] nsei = new int[arr.length];

		// rightward check
		for (int i = arr.length - 1; i >= 0; i--) {

			// This pops out equal elements to avoid double counting
			while (!st.isEmpty() && arr[st.peek()] >= arr[i])
				st.pop();

			if (st.isEmpty())
				nsei[i] = arr.length;// if no nse is found for given arr[i] then have nse as n
			else // if(!st.isEmpty() && arr[st.peek() < arr[i]]
				nsei[i] = st.peek();

			st.push(i);
		}

		return nsei;
	}

	public static void main(String[] args) {

		int[] arr = { 3, 1, 1, 4 }; // duplicate data
		// int[] arr = { 3, 1, 2, 4 };
		// int[] arr = { 1, 2, 3 };

		System.out.println("Min Sum using Brute Force : " + sumOfMinEleInSubArr_BruteForce(arr));
		System.out.println("Min Sum using Monotonic Stack : " + sumOfMinEleInSubArr_Stack(arr));
	}
}
