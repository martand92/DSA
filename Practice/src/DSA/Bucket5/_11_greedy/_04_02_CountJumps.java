package DSA.Bucket5._11_greedy;

public class _04_02_CountJumps {

	public static int getMinJumps(int[] nums, int index) {

		// to jump from last to last index, need 0 jumps
		if (index >= nums.length - 1)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= nums[index]; i++)
			min = Math.min(min, getMinJumps(nums, index + i) + 1);

		return min;
	}

	public static void main(String[] args) {
		// int[] nums = { 1, 2, 1, 1, 1 };
		int[] nums = { 3, 2, 1, 0, 4 }; // cannot reach last index
		// int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(getMinJumps(nums, 0));
	}

}