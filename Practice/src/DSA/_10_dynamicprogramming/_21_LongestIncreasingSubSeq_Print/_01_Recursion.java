package DSA._10_dynamicprogramming._21_LongestIncreasingSubSeq_Print;

import java.util.ArrayList;

public class _01_Recursion {

	public static ArrayList<Integer> longestIncreasingSubSeq(int[] arr, int index, int prevIndex,
			ArrayList<Integer> list, ArrayList<Integer> maxList) {

		if (index == arr.length) {
			if (maxList.size() < list.size())
				maxList.addAll(list);
			return maxList;
		}

		if (prevIndex == -1 || (arr[prevIndex] - arr[index] < 0)) {
			list.add(arr[index]);
			maxList = longestIncreasingSubSeq(arr, index + 1, index, list, maxList);
			list.remove(list.size() - 1);
		}

		maxList = longestIncreasingSubSeq(arr, index + 1, prevIndex, list, maxList);

		return maxList;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };
		System.out.println(longestIncreasingSubSeq(arr, 0, -1, new ArrayList<Integer>(), new ArrayList<Integer>()));
	}

}

//TC : O(2^n)
//SC : O(n)