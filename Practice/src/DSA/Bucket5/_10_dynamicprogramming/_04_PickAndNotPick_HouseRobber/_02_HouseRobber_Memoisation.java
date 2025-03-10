package DSA.Bucket5._10_dynamicprogramming._04_PickAndNotPick_HouseRobber;

import java.util.ArrayList;
import java.util.Arrays;

public class _02_HouseRobber_Memoisation {

	public static int getLargestSum(ArrayList<Integer> house, int n, int[] dp) {

		if (n == 0)
			return house.get(0);

		if (n < 0)
			return 0;

		if (dp[n] != -1)
			return dp[n];

		int left = getLargestSum(house, n - 2, dp) + house.get(n);
		int right = getLargestSum(house, n - 1, dp) + 0;

		return dp[n] = Math.max(left, right);
	}

	public static void main(String[] args) {

		int[] house = { 1, 2, 3, 1 };

		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();

		for (int i = 0; i < house.length; i++) {

			if (i != 0)
				first.add(house[i]);

			if (i != house.length - 1)
				second.add(house[i]);
		}

		int[] dp = new int[first.size()];
		Arrays.fill(dp, -1);
		int firstSum = getLargestSum(first, first.size() - 1, dp);

		dp = new int[second.size()];
		Arrays.fill(dp, -1);
		int secondSum = getLargestSum(second, second.size() - 1, dp);

		System.out.println(Math.max(firstSum, secondSum));
	}
}
