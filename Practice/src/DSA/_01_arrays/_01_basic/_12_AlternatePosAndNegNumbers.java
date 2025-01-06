package DSA._01_arrays._01_basic;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1
//Time : O(N), Space : O(N)
public class _12_AlternatePosAndNegNumbers {

	public static int[] altNums(int[] arr) {

		Queue<Integer> qPos = new LinkedList<Integer>();
		Queue<Integer> qNeg = new LinkedList<Integer>();

		for (int i = 0; i < arr.length; i++) { // O(N)
			if (arr[i] >= 0)
				qPos.add(arr[i]);
			else
				qNeg.add(arr[i]);
		}

		int i = 0;

		while (!qPos.isEmpty() && !qNeg.isEmpty()) { // O(N)
			arr[i++] = qPos.poll();
			arr[i++] = qNeg.poll();
		}

		while (!qPos.isEmpty())
			arr[i++] = qPos.poll();

		while (!qNeg.isEmpty())
			arr[i++] = qNeg.poll();

		return arr;

		// TC : O(2n)
		// SC : O(n)

	}

	public static void main(String[] args) {

		int[] arr = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };
		System.out.println(Arrays.toString(altNums(arr)));
	}

}
