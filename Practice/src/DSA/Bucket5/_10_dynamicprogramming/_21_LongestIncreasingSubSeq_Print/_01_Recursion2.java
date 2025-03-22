package DSA.Bucket5._10_dynamicprogramming._21_LongestIncreasingSubSeq_Print;

import java.util.ArrayList;

//Below algo is an inspiration from ShortestCommonSuperSeq
public class _01_Recursion2 {

	public static ArrayList<Integer> longestIncreasingSubSeq(int[] arr, int index, int prevIndex,
			ArrayList<Integer> list) {

		if (index == arr.length)
			return new ArrayList<Integer>(list);

		ArrayList<Integer> pickList = new ArrayList<Integer>();
		if (prevIndex == -1 || (arr[prevIndex] < arr[index])) {
			list.add(arr[index]);
			pickList = longestIncreasingSubSeq(arr, index + 1, index, list);
			list.remove(list.size() - 1);// As list is only added if condition is satisfied, so remove within this
											// condition
		}

		ArrayList<Integer> unPickList = longestIncreasingSubSeq(arr, index + 1, prevIndex, list);

		if (pickList.size() > unPickList.size())
			return pickList;
		else
			return unPickList;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };
		System.out.println(longestIncreasingSubSeq(arr, 0, -1, new ArrayList<Integer>()));
	}
}

//TC : O(2^n)
//SC : O(n)