package DSA._11_greedy._04_JumpGame._02_JumpGame;

public class _01_Recursion {

	public static int getMinJumps(int[] nums, int index, int jumps) {

		if (index == nums.length - 1)
			return jumps;

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= nums[index]; i++)
			min = Math.min(min, getMinJumps(nums, index + i, jumps + 1));

		return min;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 1, 1 };
		System.out.println(getMinJumps(nums, 0, 0));
	}

}
