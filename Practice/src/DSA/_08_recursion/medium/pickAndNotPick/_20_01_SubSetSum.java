package DSA._08_recursion.medium.pickAndNotPick;

import java.util.*;

//https://www.youtube.com/watch?v=rYkfBRtMJr8
public class _20_01_SubSetSum {

	public static ArrayList<Integer> findSubSetSum(int[] arr, int index, int sum, ArrayList<Integer> subSetSum) {

		if (index == arr.length) {
			subSetSum.add(sum);
			return subSetSum;
		}

		findSubSetSum(arr, index + 1, sum + arr[index], subSetSum);
		findSubSetSum(arr, index + 1, sum, subSetSum);
		return subSetSum;
	}

	public static void main(String[] args) {

		int[] arr = { 3, 1, 2 };
		ArrayList<Integer> subsetSum = findSubSetSum(arr, 0, 0, new ArrayList<Integer>());
		// Collections.sort(subsetSum);
		System.out.println(subsetSum);
	}

}

//TC : O(2^n)
//SC : O(n)