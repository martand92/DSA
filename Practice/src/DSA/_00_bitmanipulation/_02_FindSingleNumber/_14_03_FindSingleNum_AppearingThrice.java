package DSA._00_bitmanipulation._02_FindSingleNumber;

public class _14_03_FindSingleNum_AppearingThrice {

	public static int findSingleNum(int[] nums) {

		int ones = 0, twos = 0;

		for (int i = 0; i < nums.length; i++) {
			ones = (ones ^ nums[i]) & (~twos);
			twos = (twos ^ nums[i]) & (~ones);
		}

		return ones;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 2, 1, 1, 4, 3, 4, 4 };
		// int[] nums = { 2, 3, 2 };
		System.out.println(findSingleNum(nums));
	}
}
//TC : O(n)