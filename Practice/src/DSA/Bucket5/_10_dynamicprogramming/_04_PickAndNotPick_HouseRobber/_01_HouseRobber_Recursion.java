package DSA.Bucket5._10_dynamicprogramming._04_PickAndNotPick_HouseRobber;

import java.util.ArrayList;

public class _01_HouseRobber_Recursion {

	public static int getLargestSum(ArrayList<Integer> house, int n) {

		if (n == 0)
			return house.get(0);

		if (n < 0)
			return 0;

		int left = getLargestSum(house, n - 2) + house.get(n);
		int right = getLargestSum(house, n - 1) + 0;

		return Math.max(left, right);
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
