package DSA.Bucket1._00_bitmanipulation._02_FindSingleNumber;

import java.util.Arrays;

public class _14_02_FindSingleNum_AppearingThrice {

	public static int findSingleNum(int[] nums) {

		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i = i + 3) {
			if (nums[i] != nums[i - 1])
				return nums[i - 1];
		}

		return nums[nums.length - 1]; // if last num is single number then return last num
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 2, 1, 1, 4, 3, 4, 4 };
		System.out.println(findSingleNum(nums));
	}
}
//TC : n logn + (n / 3)