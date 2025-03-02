package DSA.Bucket1._00_bitmanipulation._02_FindSingleNumber;

import java.util.Arrays;

public class _15_FindSingleNum_2_DistinctElements {

	public static int[] findSingleNum(int[] nums) {

		int res = 0, bucket1 = 0, bucket2 = 0;
		int[] distinctEle = new int[2];

		for (int i = 0; i < nums.length; i++) // O(N)
			res ^= nums[i];

		int setBit = res & (res - 1) ^ res;

		for (int i = 0; i < nums.length; i++) { // O(N)

			if ((nums[i] & setBit) != 0)
				bucket2 ^= nums[i];
			else
				bucket1 ^= nums[i];
		}

		distinctEle[0] = bucket1;
		distinctEle[1] = bucket2;
		return distinctEle; // O(N) + O(N) = O(2N)
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 2, 14, 3, 7, 7, 3 };
		System.out.println(Arrays.toString(findSingleNum(nums)));
	}
}
