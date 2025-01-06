package DSA._00_bitmanipulation;

import java.util.ArrayList;

//to find all the sub sequences
public class _16_PowerSet {

	public static ArrayList<ArrayList<Integer>> powerSet(int[] nums) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < Math.pow(2, nums.length); i++) {

			ArrayList<Integer> list = new ArrayList<Integer>();

			for (int j = 0; j < nums.length; j++) {

				if ((i & (1 << j)) != 0) {
					list.add(nums[j]);
				}
			}

			result.add(list);
		}

		return result;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(powerSet(nums));
	}
}
