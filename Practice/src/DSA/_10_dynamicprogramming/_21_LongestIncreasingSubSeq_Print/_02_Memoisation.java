package DSA._10_dynamicprogramming._21_LongestIncreasingSubSeq_Print;

import java.util.ArrayList;

public class _02_Memoisation {

	public static ArrayList<Integer> longestIncreasingSubSeq(int[] arr, int index, int prevIndex,
			ArrayList<Integer> list, ArrayList<Integer> maxList, ArrayList<Integer>[][] dp) {

		if (index == arr.length) {
			if (maxList.size() < list.size())
				maxList.addAll(list);
			return maxList;
		}

		if (dp[index][prevIndex + 1] != null)
			return dp[index][prevIndex + 1];

		if (prevIndex == -1 || arr[prevIndex] < arr[index]) {
			list.add(arr[index]);
			maxList = longestIncreasingSubSeq(arr, index + 1, index, list, maxList, dp);
			list.remove(list.size() - 1);
		}

		maxList = longestIncreasingSubSeq(arr, index + 1, prevIndex, list, maxList, dp);

		return dp[index][prevIndex + 1] = maxList;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 7 };

		ArrayList<Integer>[][] dp = new ArrayList[arr.length][arr.length + 1];
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++)
//				dp[i][j] = null;
//		}

		//System.out.println(Arrays.deepToString(dp));
		System.out.println(longestIncreasingSubSeq(arr, 0, -1, new ArrayList<Integer>(), new ArrayList<Integer>(), dp));
	}

}

//TC : O(2^n)
//SC : O(n)