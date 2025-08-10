package DSA.Bucket1._00_bitmanipulation._02_FindSingleNumber;

public class _13_01_FindSingleNum_OtherAppearTwice {

	public static int findSingleNum(int[] nums) {
		int res = 0;

		for (int i = 0; i < nums.length; i++)
			res ^= nums[i];

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(findSingleNum(nums));
	}

}