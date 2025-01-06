package DSA._10_dynamicprogramming._04_PickAndNotPick_HouseRobber;

import java.util.ArrayList;

public class _03_HouseRobber_Tabulation {

	public static int getLargestSum(ArrayList<Integer> house, int n, int[] dp) {

		dp[0] = house.get(0);

		for (int i = 1; i <= n; i++) {

			int left = 0;

			if (i > 1)
				left = dp[i - 2] + house.get(i);
			else
				left = house.get(i);

			int right = dp[i - 1] + 0;

			dp[i] = Math.max(left, right);
		}

		return dp[dp.length - 1];
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
		int firstSum = getLargestSum(first, first.size() - 1, dp);

		dp = new int[second.size()];
		int secondSum = getLargestSum(second, second.size() - 1, dp);

		System.out.println(Math.max(firstSum, secondSum));
	}
}
