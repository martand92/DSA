package DSA._10_dynamicprogramming._04_PickAndNotPick_HouseRobber;

import java.util.ArrayList;

public class _04_HouseRobber_Tabulation_SpaceOpt {

	public static int getLargestSum(ArrayList<Integer> house, int n) {

		int prev2 = 0;
		int prev1 = house.get(0);

		for (int i = 1; i <= n; i++) {

			int left = prev2 + house.get(i);

			int right = prev1 + 0;

			prev2 = prev1;
			prev1 = Math.max(left, right);
		}

		return prev1;
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

		int firstSum = getLargestSum(first, first.size() - 1);
		int secondSum = getLargestSum(second, second.size() - 1);

		System.out.println(Math.max(firstSum, secondSum));
	}
}
