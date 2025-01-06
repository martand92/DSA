package DSA._00_bitmanipulation._02_FindSingleNumber;

import java.util.HashMap;
import java.util.Map;

public class _13_00_FindSingleNum_BruteForce {

	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public static int findSingleNum(int[] nums) {

		for (int i = 0; i < nums.length; i++)
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

		for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
			if (e.getValue() == 1) {
				return e.getKey();
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(findSingleNum(nums));
	}

}