package DSA.Bucket4._06_stacks;

import java.util.Stack;

//Need to find sum of maximum numbers from all possible sub arrays
public class _23_02_SumOfSubArrOfMaximums {

	public static int sumOfMaxEleInSubArr_BruteForce(int[] arr) {

		int sum = 0;
		int mod = (int) 1e9 + 7;
		for (int i = 0; i < arr.length; i++) {

			int max = Integer.MIN_VALUE;

			for (int j = i; j < arr.length; j++) { // subArray is from i to j
				max = Math.max(max, arr[j]);
				sum += max % mod;
			}

		}

		return sum;
		// TC: O(N^2), SC: O(1)
	}

	// TC : O(N), SC : O(N)
	public static int sumOfMaxEleInSubArr_Stack(int[] arr) {

		int total = 0;
		int[] pge = findPrevGreaterEqualElement(arr); // SC : O(N)
		int[] nge = findNxtGreaterElement(arr); // SC : O(N)

		for (int i = 0; i < arr.length; i++) { // TC : O(N)
			int left = i - pge[i];
			int right = nge[i] - i;
			total += (left * right) * arr[i];
		}

		return total;

		// SC : O(2N)
		// TC : O(N)
	}

	private static int[] findPrevGreaterEqualElement(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();
		int[] pge = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!st.isEmpty() && arr[st.peek()] < arr[i])
				st.pop();

			if (st.isEmpty())
				pge[i] = -1;
			else
				pge[i] = st.peek();

			st.push(i);
		}

		return pge;

	}

	private static int[] findNxtGreaterElement(int[] arr) {

		Stack<Integer> st = new Stack<Integer>();
		int[] nge = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && arr[st.peek()] <= arr[i])
				st.pop();

			if (st.isEmpty())
				nge[i] = arr.length;// if no nge is found for given arr[i] then have nge as n
			else
				nge[i] = st.peek();

			st.push(i);
		}

		return nge;
	}

	public static void main(String[] args) {

		// int[] arr = { 3, 1, 1, 4 };
		int[] arr = { 3, 1, 2, 4 };

		System.out.println("Max sum using Brute Force : " + sumOfMaxEleInSubArr_BruteForce(arr));
		System.out.println("Max sum using Monotonic Stack : " + sumOfMaxEleInSubArr_Stack(arr));
	}

}
